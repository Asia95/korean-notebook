package com.janaszek.kn.vocabulary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.janaszek.kn.R
import kotlinx.android.synthetic.main.activity_vocabulary_category.*

class VocabularyCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary_category)

        vocabulary_beginner_btn.setOnClickListener {
            val i = Intent(this, VocabularyRVActivity2::class.java)
            i.putExtra("category", vocabulary_beginner_btn.text)
            startActivity(i)
        }

        vocabulary_intermediate_btn.setOnClickListener {
            val i = Intent(this, VocabularyRVActivity2::class.java)
            i.putExtra("category", vocabulary_intermediate_btn.text)
            startActivity(i)
        }
    }
}
