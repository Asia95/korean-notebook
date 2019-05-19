package org.konan.multiplatform

import android.app.Application
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.janaszek.kn.DBOpenHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.greeting.Factory
import org.greeting.PokeApi
import kotlin.properties.Delegates
import org.greeting.VocabularyWordModel
import org.konan.multiplatform.com.janaszek.kn.PokeListAdapter
import kotlin.coroutines.CoroutineContext
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Main

    private lateinit var api: PokeApi
    private val adapter = PokeListAdapter()

    private var rootLayout: LinearLayout by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.root_view) as LinearLayout
//        rootLayout.removeAllViews()

        job = Job()
        api = PokeApi()

        setupRecyclerView()
        loadList()

        button.setOnClickListener {
            println("load list")
            loadList()
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

    private fun setupRecyclerView() {
        pokelist_rv.layoutManager = LinearLayoutManager(this)
        pokelist_rv.adapter = adapter
        pokelist_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun loadList(){
        api.getPokemonList (
                success = { launch(Main) { adapter.updateData(it) } },
                failure = ::handleError
        )
    }

    private fun handleError(ex: Throwable?){
        ex?.printStackTrace()
        launch (Main){
            val msg = ex?.message ?: "Unknown error"
            Snackbar.make(root_view, msg, Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry") { loadList() }
                    .show()
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}