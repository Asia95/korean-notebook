package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class Grammar(
        val grammar: Map<GrammarCategory, GrammarEntry>,
        val grammarCategory: List<GrammarCategory>
)