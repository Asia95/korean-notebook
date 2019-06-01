package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class VocabularyCategoryEntry (
        val category: List<VocabularyEntry>
)