package com.janaszek.kn.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.janaszek.kn.R
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.view.View

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
        mCardBackLayout = findViewById(R.id.card_back)
        mCardFrontLayout = findViewById(R.id.card_front)
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
