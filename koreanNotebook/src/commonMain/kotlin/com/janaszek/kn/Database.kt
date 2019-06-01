package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable

@Serializable
data class Database (
        val grammar: GrammarCategory,
        val vocabulary: VocabularyCategory
)