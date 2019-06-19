package com.janaszek.kn.grammar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.janaszek.kn.R
import com.janaszek.kn.ServiceLocator
import kotlinx.android.synthetic.main.activity_grammar_rv.*
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry
import org.koreanNotebook.com.janaszek.kn.presentation.grammar.GrammarView

class GrammarRVActivity2 : AppCompatActivity(), GrammarView {

    private val grammarAdapter = GrammarAdapter()
    private val presenter by lazy { ServiceLocator.grammarPresenter }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_rv)

        grammarlist_rv.layoutManager = LinearLayoutManager(this)
        grammarlist_rv.adapter = grammarAdapter
        grammarlist_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this, intent.getStringExtra("category"))
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun setGrammar(grammar: List<GrammarEntry>) {
        grammarAdapter.updateData(grammar)
    }

    override fun showGrammarFailedToLoad() {
        Toast.makeText(this, "Grammar failed to load", Toast.LENGTH_LONG).show()
    }

    override fun setLoadingVisible(visible: Boolean) {

    }
}