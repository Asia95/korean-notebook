@file:Suppress("MemberVisibilityCanBePrivate")

package com.janaszek.kn

import io.ktor.client.engine.HttpClientEngine
import org.koreanNotebook.DatabaseApi
import org.koreanNotebook.com.janaszek.kn.presentation.grammar.GrammarPresenter
import org.koreanNotebook.com.janaszek.kn.presentation.grammar.VocabularyPresenter
import org.koreanNotebook.com.janaszek.kn.usecase.GetGrammar
import org.koreanNotebook.com.janaszek.kn.usecase.GetVocabulary
import kotlin.native.concurrent.ThreadLocal

/**
 * A basic service locator implementation, as any frameworks like `Kodein` don't really work at the moment.
 */
@ThreadLocal
object ServiceLocator {

    val databaseApi by lazy { DatabaseApi(PlatformServiceLocator.httpClientEngine) }

    val getGrammar: GetGrammar
        get() = GetGrammar(databaseApi)

    val grammarPresenter: GrammarPresenter
        get() = GrammarPresenter(getGrammar)

    val getVocabulary: GetVocabulary
        get() = GetVocabulary(databaseApi)

    val vocabularyPresenter: VocabularyPresenter
        get() = VocabularyPresenter(getVocabulary)
}

/**
 * Contains some expected dependencies for the [ServiceLocator] that have to be resolved by Android/iOS.
 */
expect object PlatformServiceLocator {

    val httpClientEngine: HttpClientEngine
}
