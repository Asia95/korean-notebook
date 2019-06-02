package org.koreanNotebook.com.janaszek.kn.grammar

import kotlinx.serialization.Serializable

@Serializable
data class GrammarCategoryEntry (
        val category: List<GrammarEntry>
)