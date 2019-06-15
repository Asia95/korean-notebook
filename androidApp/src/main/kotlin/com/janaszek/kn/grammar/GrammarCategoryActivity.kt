package com.janaszek.kn.grammar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.janaszek.kn.R
import kotlinx.android.synthetic.main.activity_grammar_category.*

class GrammarCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_category)

        grammar_beginner_btn.setOnClickListener {
            val i = Intent(this, GrammarRVActivity::class.java)
            i.putExtra("category", grammar_beginner_btn.text)
            startActivity(i)
        }

        grammar_intermediate_btn.setOnClickListener {
            val i = Intent(this, GrammarRVActivity::class.java)
            i.putExtra("category", grammar_intermediate_btn.text)
            startActivity(i)
        }
    }
}
