package org.koreanNotebook.com.janaszek.kn

import org.koreanNotebook.com.janaszek.kn.grammar.GrammarEntry
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

data class Database(
        val grammar: List<GrammarEntry>,
        val vocabulary: List<VocabularyEntry>
)