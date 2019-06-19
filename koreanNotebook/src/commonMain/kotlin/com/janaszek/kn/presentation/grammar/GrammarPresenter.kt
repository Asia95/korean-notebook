package org.koreanNotebook.com.janaszek.kn.presentation.grammar

import kotlinx.coroutines.launch
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry
import org.koreanNotebook.com.janaszek.kn.presentation.BasePresenter
import org.koreanNotebook.com.janaszek.kn.usecase.GetGrammar
import org.koreanNotebook.defaultDispatcher
import kotlin.coroutines.CoroutineContext

class GrammarPresenter(
        private val getGrammar: GetGrammar,
        coroutineContext: CoroutineContext = defaultDispatcher
) : BasePresenter<GrammarView>(coroutineContext) {

    override fun onViewAttached(view: GrammarView, category: String) {
        view.setLoadingVisible(true)
        getGrammar(category)
    }

    private fun getGrammar(category: String) {
        scope.launch {
            getGrammar(
                category,
                onSuccess = { view?.setGrammar(it) },
                onFailure = { view?.showGrammarFailedToLoad() }
            )
            view?.setLoadingVisible(false)
        }
    }
}

interface GrammarView {

    fun setGrammar(grammar: List<GrammarEntry>)

    fun showGrammarFailedToLoad()

    fun setLoadingVisible(visible: Boolean)
}