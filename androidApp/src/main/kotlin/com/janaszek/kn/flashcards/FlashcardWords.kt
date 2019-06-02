package com.janaszek.kn.flashcards

import android.app.Application
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

class FlashcardWords : Application() {
    lateinit var words : HashSet<VocabularyEntry>
}