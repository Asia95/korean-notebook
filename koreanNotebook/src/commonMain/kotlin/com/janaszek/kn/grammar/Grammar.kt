package org.koreanNotebook.com.janaszek.kn.grammar

import kotlinx.serialization.Serializable

@Serializable
data class Grammar(
        val grammar: Map<GrammarCategory, GrammarEntry>,
        val grammarCategory: List<GrammarCategory>
)