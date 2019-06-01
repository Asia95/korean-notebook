package org.koreanNotebook

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.koreanNotebook.com.janaszek.kn.*

class DatabaseApi {

    private val httpClient = HttpClient()
    private val databaseURL = "https://api.myjson.com/bins/wdc5k"

    fun getGrammarCategories(success: (List<String>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>(databaseURL)

                var grammar = Json.nonstrict.parse(Database.serializer(), database).grammar

                var grammarCategory: ArrayList<String> = ArrayList()
                grammar.category
                val iterator = grammar.category.iterator()
                iterator.forEach { cat ->
                    cat.jsonObject.forEach { gram -> grammarCategory.add(gram.key) }
                }
                success(grammarCategory)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    fun getBeginnerGrammar(success: (List<GrammarEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>(databaseURL)

                var grammar = Json.nonstrict.parse(Database.serializer(), database).grammar

                val grammarEntry: ArrayList<GrammarEntry> = ArrayList()
                val iterator = grammar.category.iterator()
                while (iterator.hasNext()) {
                    val cat = iterator.next()
                    val beginer = (cat as JsonObject).getArray("beginner")
                    beginer.forEach {
                        val entry = Json.nonstrict.parse(GrammarEntry.serializer(), it.toString())
                        grammarEntry.add(entry)
                    }
                    break
                }
                success(grammarEntry)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    fun getBeginnerVocabulary(success: (List<VocabularyEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>(databaseURL)

                var vocabulary = Json.nonstrict.parse(Database.serializer(), database).vocabulary

                val vocabularyEntry: ArrayList<VocabularyEntry> = ArrayList()
                val iterator = vocabulary.category.iterator()
                while (iterator.hasNext()) {
                    val cat = iterator.next()
                    val beginer = (cat as JsonObject).getArray("beginer")
                    beginer.forEach {
                        val entry = Json.nonstrict.parse(VocabularyEntry.serializer(), it.toString())
                        vocabularyEntry.add(entry)
                    }
                    break
                }
                success(vocabularyEntry)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }
}