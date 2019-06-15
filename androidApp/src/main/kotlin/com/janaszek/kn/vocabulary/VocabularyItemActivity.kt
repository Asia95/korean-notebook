package com.janaszek.kn.vocabulary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.janaszek.kn.R
import com.janaszek.kn.flashcards.FlashcardWords
import kotlinx.android.synthetic.main.activity_vocabulary_item.*
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

class VocabularyItemActivity : AppCompatActivity() {

    var word: String = ""
    var description: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary_item)

        word = intent.getStringExtra("word")
        description = intent.getStringExtra("description")

        vocabulary_word.text = word
        vocabulary_description.text = description
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.mybutton -> {
            FlashcardWords.Companion.words.add(VocabularyEntry(description, word))
            Toast.makeText(applicationContext, "Added to flashcards", Toast.LENGTH_LONG).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}
