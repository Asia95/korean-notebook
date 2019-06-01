package com.janaszek.kn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.janaszek.kn.flashcards.FlashcardsActivity
import com.janaszek.kn.grammar.GrammarCategoryActivity
import com.janaszek.kn.vocabulary.VocabularyCategoryActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grammar_btn.setOnClickListener {
            val i = Intent(this, GrammarCategoryActivity::class.java)
            startActivity(i)
        }

        vocab_btn.setOnClickListener {
            val i = Intent(this, VocabularyCategoryActivity::class.java)
            startActivity(i)
        }

        flashcards_btn.setOnClickListener {
            val i = Intent(this, FlashcardsActivity::class.java)
            startActivity(i)
        }

//        val dbHandler = DBOpenHelper(this, null)
//        val user = VocabularyWordModel("hello")
//        dbHandler.addName(user)
//
//        val cursor = dbHandler.getAllName()
//        cursor!!.moveToFirst()
//        Toast.makeText(this, (cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME))), Toast.LENGTH_LONG).show()
//        while (cursor.moveToNext()) {
//            println((cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME))))
//        }
//        cursor.close()

//        val product = Factory.create(mapOf("user" to "JetBrains"))
//        val tv = TextView(this)
//        tv.text = product.toString()
//        rootLayout.addView(tv)
    }
}