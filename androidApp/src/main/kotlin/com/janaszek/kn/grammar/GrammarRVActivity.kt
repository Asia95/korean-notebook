package com.janaszek.kn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_grammar.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.greeting.DatabaseApi
import kotlin.coroutines.CoroutineContext

class GrammarRVActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private lateinit var job: Job
    private lateinit var api: DatabaseApi
    private val adapter = GrammarAdapter()
    private val grammarList: ArrayList<GrammarEntry> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_rv)

        setupRecyclerView()
        job = Job()
        api = DatabaseApi()

        intent.getStringExtra("category")
        loadList()
    }

    private fun setupRecyclerView() {
        grammarlist_rv.layoutManager = LinearLayoutManager(this)
        grammarlist_rv.adapter = adapter
        grammarlist_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun loadList(){
        api.getBeginnerGrammar (
                success = { launch(Dispatchers.Main) { adapter.updateData(it) }},
                failure = ::handleError
        )
    }

    private fun handleError(ex: Throwable?){
        ex?.printStackTrace()
        launch (Dispatchers.Main){
            val msg = ex?.message ?: "Unknown error"
            Snackbar.make(root_view, msg, Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry") { loadList() }
                    .show()
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}

