package com.janaszek.kn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.janaszek.kn.grammar.GrammarAdapter
import com.janaszek.kn.vocabulary.VocabularyAdapter
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koreanNotebook.DatabaseApi
import kotlin.coroutines.CoroutineContext

class SearchActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private lateinit var job: Job
    private lateinit var api: DatabaseApi
    private val vocabularyAdapter = VocabularyAdapter()
    private val grammarAdapter = GrammarAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupRecyclerView()
        job = Job()
        var query = intent.getStringExtra("query")
        api = DatabaseApi()

        searchInGrammar(query)
        searchInVocabulary(query)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchInGrammar(query)
                searchInVocabulary(query)
                return false
            }

        })
    }

    private fun setupRecyclerView() {
        search_grammar_rv.layoutManager = LinearLayoutManager(this)
        search_grammar_rv.adapter = grammarAdapter
        search_grammar_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        search_vocabulary_rv.layoutManager = LinearLayoutManager(this)
        search_vocabulary_rv.adapter = vocabularyAdapter
        search_vocabulary_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun searchInGrammar(query: String){
        api.searchInGrammar (
                query = query,
                success = { launch(Dispatchers.Main) { grammarAdapter.updateData(it) }},
                failure = ::handleError
        )
    }

    private fun searchInVocabulary(query: String){
        api.searchInVocabulary (
                query = query,
                success = { launch(Dispatchers.Main) { vocabularyAdapter.updateData(it) }},
                failure = ::handleError
        )
    }

    private fun handleError(ex: Throwable?){
        ex?.printStackTrace()
        launch (Dispatchers.Main){
            val msg = ex?.message ?: "Unknown error"
            Snackbar.make(activity_search, msg, Snackbar.LENGTH_INDEFINITE).show()
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}
