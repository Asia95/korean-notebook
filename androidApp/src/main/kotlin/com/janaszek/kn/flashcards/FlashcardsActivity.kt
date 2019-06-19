package com.janaszek.kn.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.janaszek.kn.R
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.view.View
import kotlinx.android.synthetic.main.activity_flashcards.*
import kotlinx.android.synthetic.main.card_back.*
import kotlinx.android.synthetic.main.card_front.*

class FlashcardsActivity : AppCompatActivity() {

    private var mSetRightOut: AnimatorSet? = null
    private var mSetLeftIn: AnimatorSet? = null
    private var mIsBackVisible = false
    private var mCardFrontLayout: View? = null
    private var mCardBackLayout: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcards)
        findViews()

        val words = FlashcardWords.Companion.words.iterator()
        if (words.hasNext()) {
            val word = words.next()
            card_front_text.text = word.title
            card_back_text.text = word.explanation
        }

        loadAnimations()
        changeCameraDistance()

        next_card_btn.setOnClickListener {
            if (words.hasNext()) {
                if (mIsBackVisible)
                    flipCard(mCardFrontLayout)
                val word = words.next()
                card_front_text.text = word.title
                card_back_text.text = word.explanation
            } else {
                flashcard.visibility = View.GONE
                if (savedInstanceState == null) {
                    supportFragmentManager
                            .beginTransaction()
                            .add(R.id.flashcards_view, FlashcardsEndFragment.newInstance(), "flashcardsEnd")
                            .commit()
                }
            }
        }
    }

    private fun changeCameraDistance() {
        val distance = 8000
        val scale = resources.displayMetrics.density * distance
        mCardFrontLayout?.cameraDistance = scale
        mCardBackLayout?.cameraDistance = scale
    }

    private fun loadAnimations() {
        mSetRightOut = AnimatorInflater.loadAnimator(this, R.animator.out_animation) as AnimatorSet
        mSetLeftIn = AnimatorInflater.loadAnimator(this, R.animator.in_animation) as AnimatorSet
    }

    private fun findViews() {
        mCardBackLayout = card_back
        mCardFrontLayout = card_front
    }

    fun flipCard(view: View?) {
        if (!mIsBackVisible) {
            mSetRightOut?.setTarget(mCardFrontLayout)
            mSetLeftIn?.setTarget(mCardBackLayout)
            mSetRightOut?.start()
            mSetLeftIn?.start()
            mIsBackVisible = true
        } else {
            mSetRightOut?.setTarget(mCardBackLayout)
            mSetLeftIn?.setTarget(mCardFrontLayout)
            mSetRightOut?.start()
            mSetLeftIn?.start()
            mIsBackVisible = false
        }
    }
}
