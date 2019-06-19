package com.janaszek.kn.vocabulary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.janaszek.kn.R
import com.janaszek.kn.ServiceLocator
import com.janaszek.kn.grammar.GrammarAdapter
import kotlinx.android.synthetic.main.activity_grammar_rv.*
import kotlinx.android.synthetic.main.activity_vocabulary_rv.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koreanNotebook.DatabaseApi
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry
import org.koreanNotebook.com.janaszek.kn.presentation.grammar.VocabularyView
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry
import kotlin.coroutines.CoroutineContext

class VocabularyRVActivity2 : AppCompatActivity(), VocabularyView {

    private val vocabularyAdapter = VocabularyAdapter()
    private val presenter by lazy { ServiceLocator.vocabularyPresenter }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary_rv)

        vocabularylist_rv.layoutManager = LinearLayoutManager(this)
        vocabularylist_rv.adapter = vocabularyAdapter
        vocabularylist_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this, intent.getStringExtra("category"))
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun setVocabulary(vocabulary: List<VocabularyEntry>) {
        vocabularyAdapter.updateData(vocabulary)
    }

    override fun showVocabularyFailedToLoad() {
        Toast.makeText(this, "Vocabulary failed to load", Toast.LENGTH_LONG).show()
    }

    override fun setLoadingVisible(visible: Boolean) {

    }
}

