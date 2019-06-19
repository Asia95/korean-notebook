package org.koreanNotebook.com.janaszek.kn.presentation.grammar

import kotlinx.coroutines.launch
import org.koreanNotebook.com.janaszek.kn.presentation.BasePresenter
import org.koreanNotebook.com.janaszek.kn.usecase.GetVocabulary
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry
import org.koreanNotebook.defaultDispatcher
import kotlin.coroutines.CoroutineContext

class VocabularyPresenter(
        private val getVocabulary: GetVocabulary,
        coroutineContext: CoroutineContext = defaultDispatcher
) : BasePresenter<VocabularyView>(coroutineContext) {

    override fun onViewAttached(view: VocabularyView, category: String) {
        view.setLoadingVisible(true)
        getVocabulary(category)
    }

    private fun getVocabulary(category: String) {
        scope.launch {
            getVocabulary(
                category,
                onSuccess = { view?.setVocabulary(it) },
                onFailure = { view?.showVocabularyFailedToLoad() }
            )
            view?.setLoadingVisible(false)
        }
    }
}

interface VocabularyView {

    fun setVocabulary(vocabulary: List<VocabularyEntry>)

    fun showVocabularyFailedToLoad()

    fun setLoadingVisible(visible: Boolean)
}