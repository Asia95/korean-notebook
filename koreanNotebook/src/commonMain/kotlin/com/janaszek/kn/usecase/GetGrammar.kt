package org.koreanNotebook.com.janaszek.kn.usecase

import com.janaszek.kn.Either
import com.janaszek.kn.Failure
import com.janaszek.kn.Success
import org.koreanNotebook.DatabaseApi
import org.koreanNotebook.com.janaszek.kn.Category
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry

/**
 * A `use case` to get grammar of given category.
 */
class GetGrammar(private val databaseApi: DatabaseApi) : UseCase<List<GrammarEntry>, String>() {

    override suspend fun run(params: String): Either<Exception, List<GrammarEntry>> {
        return try {
            val grammar = databaseApi.getGrammarByCategory(params)
            Success(grammar)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}