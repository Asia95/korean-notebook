package org.koreanNotebook.com.janaszek.kn.usecase

import com.janaszek.kn.Either
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koreanNotebook.ApplicationDispatcher
import org.koreanNotebook.uiDispatcher

/**
 * Base class for a `coroutine` use case.
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    /**
     * Runs the actual logic of the use case.
     */
    abstract suspend fun run(params: Params): Either<Exception, Type>

    suspend operator fun invoke(params: Params, onSuccess: (Type) -> Unit, onFailure: (Exception) -> Unit) {
        val result = run(params)
        coroutineScope {
            launch(uiDispatcher) {
                result.fold(
                    failed = { onFailure(it) },
                    succeeded = { onSuccess(it) }
                )
            }
        }
    }

    /**
     * Placeholder for a use case that doesn't need any input parameters.
     */
    object None
}

