package org.koreanNotebook.com.janaszek.kn.usecase

import com.janaszek.kn.Either
import com.janaszek.kn.Failure
import com.janaszek.kn.Success
import org.koreanNotebook.DatabaseApi
import org.koreanNotebook.com.janaszek.kn.Category
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

/**
 * A `use case` to get vocabulary of the given category.
 */
class GetVocabulary(private val databaseApi: DatabaseApi) : UseCase<List<VocabularyEntry>, String>() {

    override suspend fun run(params: String): Either<Exception, List<VocabularyEntry>> {
        return try {
            val vocabulary = databaseApi.getVocabularyByCategory(params)
            Success(vocabulary)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}