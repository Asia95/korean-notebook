package com.janaszek.kn.flashcards

import android.app.Application
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

class FlashcardWords : Application() {

    companion object {
        var words = HashSet<VocabularyEntry>()
    }

    override fun onCreate() {
        super.onCreate()
        // initialization code here
    }
}