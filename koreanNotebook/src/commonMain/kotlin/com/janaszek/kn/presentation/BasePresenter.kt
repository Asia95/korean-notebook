package org.koreanNotebook.com.janaszek.kn.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<T>(private val coroutineContext: CoroutineContext) {

    protected var view: T? = null
    protected lateinit var scope: PresenterCoroutineScope

    fun attachView(view: T, param: String) {
        this.view = view
        scope = PresenterCoroutineScope(coroutineContext)
        onViewAttached(view, param)
    }

    protected open fun onViewAttached(view: T, category: String) {}

    fun detachView() {
        view = null
        scope.viewDetached()
        onViewDetached()
    }

    protected open fun onViewDetached() {}
}

class PresenterCoroutineScope(
    context: CoroutineContext
) : CoroutineScope {

    private var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}
