package com.janaszek.kn.vocabulary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.janaszek.kn.R
import kotlinx.android.synthetic.main.activity_vocabulary_item.*

class VocabularyItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary_item)

        val word = intent.getStringExtra("word")
        val description = intent.getStringExtra("description")

        vocabulary_word.text = word
        vocabulary_description.text = description
    }

    // create an action bar button
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return true
    }

    // handle button activities
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.mybutton -> {
            // do stuff
            Toast.makeText(applicationContext, "Added to flashcards", Toast.LENGTH_LONG).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}
