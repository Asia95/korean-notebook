package com.janaszek.kn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_grammar_item.*

class GrammarItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_item)

        val title = intent.getStringExtra("title")
        val body = intent.getStringExtra("body")

        grammar_title.text = title
        grammar_body.text = body
    }
}
