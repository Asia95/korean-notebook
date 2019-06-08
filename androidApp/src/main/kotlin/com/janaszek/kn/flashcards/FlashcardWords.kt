package com.janaszek.kn.flashcards

import android.app.Application
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

object FlashcardWords : Application() {
    var words : HashSet<VocabularyEntry> = HashSet()
}