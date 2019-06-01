package com.janaszek.kn.vocabulary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}
