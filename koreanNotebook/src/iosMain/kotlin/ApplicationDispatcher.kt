package org.koreanNotebook

import kotlin.coroutines.*
import kotlinx.coroutines.*
import platform.Foundation.NSData
import platform.UIKit.UIImage
import platform.UIKit.UIView
import platform.darwin.*
import kotlin.native.concurrent.freeze

actual val uiDispatcher: CoroutineContext
    get() = IosMainDispatcher

actual val defaultDispatcher: CoroutineContext
    get() = IosMainDispatcher

/**
 * iOS doesn't have a default UI thread dispatcher like [Dispatchers.Main], so we have to implement it ourself.
 */
private object IosMainDispatcher : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }
}

internal actual val ApplicationDispatcher: CoroutineDispatcher =
        NsQueueDispatcher(dispatch_get_main_queue())


internal class NsQueueDispatcher(private val dispatchQueue: dispatch_queue_t) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue.freeze()) {
            block.run()
        }
    }
}