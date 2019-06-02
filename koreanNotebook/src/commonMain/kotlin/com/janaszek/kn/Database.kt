package org.koreanNotebook.com.janaszek.kn

import kotlinx.serialization.Serializable
import org.koreanNotebook.com.janaszek.kn.grammar.GrammarCategory
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyCategory

@Serializable
data class Database (
        val grammar: GrammarCategory,
        val vocabulary: VocabularyCategory
)