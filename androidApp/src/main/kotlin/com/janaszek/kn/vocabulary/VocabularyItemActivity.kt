package com.janaszek.kn.vocabulary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.gson.Gson
import com.janaszek.kn.R
import com.janaszek.kn.flashcards.FlashcardWords
import kotlinx.android.synthetic.main.activity_vocabulary_item.*
import org.koreanNotebook.com.janaszek.kn.flashcards.FlashcardModel
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
            val sharedPref = applicationContext?.getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE)

            val cards = FlashcardModel(arrayListOf(VocabularyEntry(word, description)))
            val json = Gson().toJson(cards)
            with (sharedPref?.edit()) {
                this?.putString("cards", json)
                this?.apply()
            }

            var words = FlashcardWords()
            words.words.add(VocabularyEntry(word, description))

//            val i = Intent(this, FlashcardsActivity::class.java)
////            i.putExtra("cards", cards)
//            startActivity(i)
            Toast.makeText(applicationContext, "Added to flashcards", Toast.LENGTH_LONG).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}
