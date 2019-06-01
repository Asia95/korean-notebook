package org.koreanNotebook

import com.janaszek.kn.Grammar
import com.janaszek.kn.GrammarEntry
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.koreanNotebook.com.janaszek.kn.Database
import org.koreanNotebook.com.janaszek.kn.GrammarCategory
import org.koreanNotebook.com.janaszek.kn.VocabularyEntry

class DatabaseApi {

    private val httpClient = HttpClient()
    private val databaseURL = "https://api.myjson.com/bins/wdc5k"

    fun getPokemonList(success: (Map<GrammarCategory, GrammarEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val firebaseUrl = "https://api.myjson.com/bins/kccyo"
                val grammar = httpClient.get<String>(firebaseUrl)
                println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")
                println(grammar)

                val ge = Json.nonstrict.parse(Grammar.serializer(), grammar).grammar.also(success)
                println(ge)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }

    fun getGrammarCategories(success: (List<String>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val database = httpClient.get<String>(databaseURL)
                println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")
                println(database)

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
                println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")
                println(database)

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
                println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")
                println(database)

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