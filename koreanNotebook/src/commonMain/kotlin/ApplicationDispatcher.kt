package org.koreanNotebook

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

internal expect val ApplicationDispatcher: CoroutineDispatcher

expect val defaultDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext