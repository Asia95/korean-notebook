package com.janaszek.kn.vocabulary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.janaszek.kn.R
import kotlinx.android.synthetic.main.activity_vocabulary_rv_item.view.*
import org.koreanNotebook.com.janaszek.kn.vocabulary.VocabularyEntry

class VocabularyAdapter : RecyclerView.Adapter<VocabularyAdapter.ViewHolder>() {

    private val vocabularyList: ArrayList<VocabularyEntry> = arrayListOf()

    override fun getItemCount(): Int {
        return vocabularyList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_vocabulary_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.word?.text = vocabularyList[position].title
        holder.explanation = vocabularyList[position].explanation
        holder.preview?.text = vocabularyList[position].explanation.take(50) + "..."
    }

    fun updateData(list: List<VocabularyEntry>) {
        vocabularyList.clear()
        vocabularyList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val word = view.vocabulary_item_word
        val preview = view.vocabulary_item_description
        var explanation = ""

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val context = v?.context
            val intent = Intent(context, VocabularyItemActivity::class.java)
            intent.putExtra("word", word.text)
            intent.putExtra("explanation", explanation)
            context?.startActivity(intent)
        }
    }
}