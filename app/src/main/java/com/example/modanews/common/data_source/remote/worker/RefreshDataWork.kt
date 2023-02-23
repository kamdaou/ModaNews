package com.example.modanews.common.data_source.remote.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.modanews.common.domain.model.Image
import com.example.modanews.common.domain.model.Link
import com.example.modanews.common.domain.model.LinkBloc
import com.example.modanews.common.domain.repository.ICommonRepository
import com.google.firebase.firestore.FirebaseFirestoreException
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.RuntimeException

@HiltWorker
class RefreshDataWork @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val repository: ICommonRepository
): CoroutineWorker(appContext, params) {
    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    /**
     * Does a coroutine work to get data from the api,
     * call a function from the repository to save them in the local database,
     * and handle exceptions: when there is runtime or firebase firestore exception
     * it stop the work, otherwise, it continue
     *
     * @return the result as Result object.
     */
    override suspend fun doWork(): Result {
        return try {
            val rubricDto = repository.getRubricsFromRemote()
            val articlesDto = repository.getArticlesFromRemote()
            val authorsDto = repository.getAuthorsFromRemote()


            for (articleDto in articlesDto) {
                val article = articleDto.toArticle()
                val comments = articleDto.toComments()
                var links = listOf<Link>()
                val blocs = articleDto.toBlocs()
                val images = mutableListOf<Image>()
                val blocLinks = mutableListOf<LinkBloc>()


                // Getting links and images of type List<Link> and List<Image> from the ArticleDto object
                articleDto.blocs.forEach { blocDto ->
                    links = blocDto.toLinks()
                    blocDto.img.map {
                        images.add(it.toImage(blocDto.blocId))
                    }
                }


                // Getting blocLinks of type List<LinkBloc> from from the ArticleDto object
                articleDto.blocs.forEach { blocDto ->

                    blocDto.links.forEach { linkDto ->
                        blocLinks.add(
                            LinkBloc(
                                blocId = blocDto.blocId,
                                linkId = linkDto.linkId
                            )
                        )

                    }

                }

                // converting list of RubricDto object into list of Rubric objects
                val rubrics = rubricDto.map {
                    it.toRubric()
                }

                // converting list of AuthorDto object into list of Author objects
                val authors = authorsDto.map {
                    it.toAuthor()
                }

                repository.saveData(article, comments, links, blocs, images, blocLinks, rubrics, authors)
            }

            Result.success()
        } catch (e: Exception) {
            if (e is FirebaseFirestoreException || e is RuntimeException) {
                    Result.failure()
            }
            else {
                Result.retry()
            }
        }
    }

}