package org.koreanNotebook.com.janaszek.kn

import com.janaszek.kn.GrammarEntry
import kotlinx.serialization.Serializable

@Serializable
data class GrammarCategoryEntry (
        val category: List<GrammarEntry>
)