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
import org.koreanNotebook.com.janaszek.kn.flashcards.FlashcardModel

class FlashcardsActivity : AppCompatActivity() {

    private var mSetRightOut: AnimatorSet? = null
    private var mSetLeftIn: AnimatorSet? = null
    private var mIsBackVisible = false
    private var mCardFrontLayout: View? = null
    private var mCardBackLayout: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcards)
//        var cards = intent.extras.getSerializable("cards") as? FlashcardModel
        findViews()

//        card_front_text.text = cards?.words?.get(0)?.word
//        card_back_text.text = cards?.words?.get(0)?.description

        loadAnimations()
        changeCameraDistance()
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

    fun flipCard(view: View) {
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
