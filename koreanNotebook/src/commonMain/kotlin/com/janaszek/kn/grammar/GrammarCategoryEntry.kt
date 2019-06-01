package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class GrammarCategoryEntry (
        val category: List<GrammarEntry>
)