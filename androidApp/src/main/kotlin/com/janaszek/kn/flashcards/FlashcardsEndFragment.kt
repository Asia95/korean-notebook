package com.janaszek.kn.flashcards

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.janaszek.kn.R
import kotlinx.android.synthetic.main.fragment_flashcards_end.*


class FlashcardsEndFragment : Fragment() {

    companion object {

        fun newInstance(): FlashcardsEndFragment {
            return FlashcardsEndFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_flashcards_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flashcards_again.setOnClickListener {
            val i = Intent(view.context, FlashcardsActivity::class.java)
            startActivity(i)
        }
    }
}