package org.koreanNotebook.com.janaszek.kn.usecase

import com.janaszek.kn.Either
import com.janaszek.kn.Failure
import com.janaszek.kn.Success
import org.koreanNotebook.DatabaseApi
import org.koreanNotebook.com.janaszek.kn.Database

class Search(private val databaseApi: DatabaseApi) : UseCase<Database, String>() {

    override suspend fun run(params: String): Either<Exception, Database> {
        return try {
            val vocabulary = databaseApi.searchInVocabulary(params)
            val grammar = databaseApi.searchInGrammar(params)
            Success(Database(grammar, vocabulary))
        } catch (e: Exception) {
            Failure(e)
        }
    }
}