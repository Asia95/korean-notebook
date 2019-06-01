package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable
import org.koreanNotebook.com.janaszek.kn.GrammarCategory

@Serializable
data class Grammar(
        val grammar: Map<GrammarCategory, GrammarEntry>,
        val grammarCategory: List<GrammarCategory>
)