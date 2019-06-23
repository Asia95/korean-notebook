package org.koreanNotebook.com.janaszek.kn.presentation

import kotlinx.coroutines.launch
import org.koreanNotebook.com.janaszek.kn.Database
import org.koreanNotebook.com.janaszek.kn.usecase.Search
import org.koreanNotebook.defaultDispatcher
import kotlin.coroutines.CoroutineContext

class SearchPresenter(
        private val getDatabase: Search,
        coroutineContext: CoroutineContext = defaultDispatcher
) : BasePresenter<SearchView>(coroutineContext) {

    override fun onViewAttached(view: SearchView, query: String) {
        view.setLoadingVisible(true)
        getSearchResults(query)
    }

    private fun getSearchResults(query: String) {
        scope.launch {
            getDatabase(
                query,
                onSuccess = { view?.setSearchResult(it) },
                onFailure = { view?.showSearchResultFailedToLoad() }
            )
            view?.setLoadingVisible(false)
        }
    }
}

interface SearchView {

    fun setSearchResult(result: Database)

    fun showSearchResultFailedToLoad()

    fun setLoadingVisible(visible: Boolean)
}