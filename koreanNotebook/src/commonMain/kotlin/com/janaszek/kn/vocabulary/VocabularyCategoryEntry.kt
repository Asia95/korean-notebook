package org.koreanNotebook.com.janaszek.kn.vocabulary

import kotlinx.serialization.Serializable

@Serializable
data class VocabularyCategoryEntry (
        val category: List<VocabularyEntry>
)