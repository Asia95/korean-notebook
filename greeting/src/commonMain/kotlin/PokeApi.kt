package org.greeting

import com.janaszek.kn.Grammar
import com.janaszek.kn.GrammarEntry
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json

class PokeApi {

    private val httpClient = HttpClient()

    fun getPokemonList(success: (List<GrammarEntry>) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val firebaseUrl = "https://api.myjson.com/bins/17yqou"
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
}