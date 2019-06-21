package org.koreanNotebook

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.get
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import org.koreanNotebook.com.janaszek.kn.grammar.Grammar
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

class DatabaseApi(clientEngine: HttpClientEngine) {

    private val httpClient = HttpClient(clientEngine)
    private val databaseURL = "https://korean-notebook.appspot.com/api"

    fun getGrammarByCategory(category: String, success: (List<GrammarEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>("$databaseURL/grammar?category=$category")
                val grammarEntry: ArrayList<GrammarEntry> = ArrayList()
                (Json.nonstrict.parseJson(database) as JsonArray).forEach {
                    val entry = Json.nonstrict.parse(GrammarEntry.serializer(), it.toString())
                    grammarEntry.add(entry)
                }
                success(grammarEntry)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    suspend fun getGrammarByCategory(category: String): ArrayList<GrammarEntry> {
        val database = httpClient.get<String>("$databaseURL/grammar?category=$category")
        val grammarEntry: ArrayList<GrammarEntry> = ArrayList()
        (Json.nonstrict.parseJson(database) as JsonArray).forEach {
            val entry = Json.nonstrict.parse(GrammarEntry.serializer(), it.toString())
            grammarEntry.add(entry)
        }
        return grammarEntry
    }

    suspend fun getVocabularyByCategory(category: String): ArrayList<VocabularyEntry> {
        val database = httpClient.get<String>("$databaseURL/vocabulary?category=$category")
        val vocabularyEntry: ArrayList<VocabularyEntry> = ArrayList()
        (Json.nonstrict.parseJson(database) as JsonArray).forEach {
            val entry = Json.nonstrict.parse(VocabularyEntry.serializer(), it.toString())
            vocabularyEntry.add(entry)
        }
        return vocabularyEntry
    }

    fun getVocabularyByCategory(category: String, success: (List<VocabularyEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>("$databaseURL/vocabulary?category=$category")
                val vocabularyEntry: ArrayList<VocabularyEntry> = ArrayList()
                (Json.nonstrict.parseJson(database) as JsonArray).forEach {
                    val entry = Json.nonstrict.parse(VocabularyEntry.serializer(), it.toString())
                    vocabularyEntry.add(entry)
                }
                success(vocabularyEntry)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    fun searchInVocabulary(query: String, success: (List<VocabularyEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>("$databaseURL/vocabulary?search=$query")
                val vocabularyEntry: ArrayList<VocabularyEntry> = ArrayList()
                (Json.nonstrict.parseJson(database) as JsonArray).forEach {
                    val entry = Json.nonstrict.parse(VocabularyEntry.serializer(), it.toString())
                    vocabularyEntry.add(entry)
                }
                success(vocabularyEntry)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    fun searchInGrammar(query: String, success: (List<GrammarEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val grammarEntry: ArrayList<GrammarEntry> = ArrayList()
                val database = httpClient.get<String>("$databaseURL/grammar?search=$query")
                (Json.nonstrict.parseJson(database) as JsonArray).forEach {
                    val entry = Json.nonstrict.parse(GrammarEntry.serializer(), it.toString())
                    grammarEntry.add(entry)
                }
                success(grammarEntry)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    suspend fun searchInVocabulary(query: String): ArrayList<VocabularyEntry> {
        val database = httpClient.get<String>("$databaseURL/vocabulary?search=$query")
        val vocabularyEntry: ArrayList<VocabularyEntry> = ArrayList()
        (Json.nonstrict.parseJson(database) as JsonArray).forEach {
            val entry = Json.nonstrict.parse(VocabularyEntry.serializer(), it.toString())
            vocabularyEntry.add(entry)
        }
        return vocabularyEntry
    }

    suspend fun searchInGrammar(query: String): ArrayList<GrammarEntry> {
        val grammarEntry: ArrayList<GrammarEntry> = ArrayList()
        val database = httpClient.get<String>("$databaseURL/grammar?search=$query")
        (Json.nonstrict.parseJson(database) as JsonArray).forEach {
            val entry = Json.nonstrict.parse(GrammarEntry.serializer(), it.toString())
            grammarEntry.add(entry)
        }
        return grammarEntry
    }
}