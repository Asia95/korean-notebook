package com.janaszek.kn

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_grammar_rv_item.view.*

class GrammarAdapter : RecyclerView.Adapter<GrammarAdapter.ViewHolder>() {

    private val grammarList: ArrayList<GrammarEntry> = arrayListOf()

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return grammarList.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_grammar_rv_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.grammarTitle?.text = grammarList[position].title
        holder.grammarBody = grammarList[position].body
        holder.grammarDescription?.text = grammarList[position].body.take(50) + "..."
    }

    fun updateData(list: List<GrammarEntry>) {
        grammarList.clear()
        grammarList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val grammarDescription = view.grammar_item_body
        val grammarTitle = view.grammar_item_title
        var grammarBody = ""

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val context = v?.context
            val intent = Intent(context, GrammarItemActivity::class.java)
            intent.putExtra("title", grammarTitle.text)
            intent.putExtra("body", grammarBody)
            context?.startActivity(intent)
        }
    }
}