package org.koreanNotebook.com.janaszek.kn.flashcards

import kotlinx.serialization.Serializable
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

@Serializable
data class FlashcardModel (
        val words: ArrayList<VocabularyEntry>
)