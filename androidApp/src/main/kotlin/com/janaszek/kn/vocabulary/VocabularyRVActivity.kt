package com.janaszek.kn.vocabulary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.janaszek.kn.R
import com.janaszek.kn.ServiceLocator
import kotlinx.android.synthetic.main.activity_vocabulary_rv.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koreanNotebook.DatabaseApi
import kotlin.coroutines.CoroutineContext

class VocabularyRVActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private lateinit var job: Job
    private lateinit var api: DatabaseApi
    private val adapter = VocabularyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary_rv)

        setupRecyclerView()
        job = Job()
        api = ServiceLocator.databaseApi

        val category = intent.getStringExtra("category")
        loadList(category)
    }

    private fun setupRecyclerView() {
        vocabularylist_rv.layoutManager = LinearLayoutManager(this)
        vocabularylist_rv.adapter = adapter
        vocabularylist_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun loadList(category: String){
        api.getVocabularyByCategory (
                category = category,
                success = { launch(Dispatchers.Main) { adapter.updateData(it) }},
                failure = ::handleError
        )
    }

    private fun handleError(ex: Throwable?){
        ex?.printStackTrace()
        launch (Dispatchers.Main){
            val msg = ex?.message ?: "Unknown error"
            Snackbar.make(activity_vocabulary_rv, msg, Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry") { loadList(intent.getStringExtra("category")) }
                    .show()
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}

