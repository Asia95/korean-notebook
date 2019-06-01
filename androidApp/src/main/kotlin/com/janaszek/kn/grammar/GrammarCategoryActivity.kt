package com.janaszek.kn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import org.greeting.DatabaseApi
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_grammar_category.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class GrammarCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_category)

        grammar_beginer_btn.setOnClickListener {
            val i = Intent(this, GrammarRVActivity::class.java)
            i.putExtra("category", grammar_beginer_btn.text)
            startActivity(i)
        }

        grammar_intermediate_btn.setOnClickListener {
            val i = Intent(this, GrammarRVActivity::class.java)
            i.putExtra("category", grammar_intermediate_btn.text)
            startActivity(i)
        }
    }
}
