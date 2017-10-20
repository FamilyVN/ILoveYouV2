package com.tuananh.iloveyouv2

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_message.view.*

class MainActivity : AppCompatActivity() {
    private var mIndex = 0
    private var mX1 = 0.0f
    private var mX2 = 0.0f
    private var mY = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonYes.setOnClickListener { v ->
            //            val builder = AlertDialog.Builder(this)
//            builder.setMessage("Anh biết mà, <3")
//                    .setPositiveButton("ОК") {
//                        dialog, whichButton ->
//                    }
//            builder.show()
            createDialog()
        }

        buttonNo.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    move()
                    true
                }
                else -> false
            }

        }
    }

    fun createDialog() {
        val customDialog = CustomDialog(this) as LinearLayout
        customDialog.textMessage.text = "Đã nghiện lại còn ngại !"
        customDialog.imageIcon.setImageResource(R.drawable.ic_11)
        val builder = AlertDialog.Builder(this)
        builder.setView(customDialog)
        builder.show()
    }

    fun move() {
        mIndex = if (mIndex < 7) mIndex + 1 else 1
//        if (mIndex < 7) {
//            mIndex += 1
//        } else {
//            mIndex = 1
//            val builder = AlertDialog.Builder(this)
//            builder.setView(R.layout.dialog_message)
//            builder.show()
//        }
        when (mIndex) {
            0 -> reset()
            1 -> {
                buttonNo.y = buttonNo.y - resources.getDimensionPixelSize(R.dimen.margin_padding_100)
                mX1 = buttonYes.x
                mX2 = buttonNo.x
                mY = buttonYes.y
            }
            2 -> {
                buttonNo.y = buttonNo.y + resources.getDimensionPixelSize(R.dimen.margin_padding_100)
            }
            3 -> {
                buttonYes.x = mX2
                buttonNo.x = mX1
            }
            4 -> {
                buttonYes.x = mX1
                buttonNo.x = mX2
            }
            5 -> {
                buttonNo.y = buttonNo.y + resources.getDimensionPixelSize(R.dimen.margin_padding_100)
            }
            6 -> {
                buttonNo.y = buttonNo.y - resources.getDimensionPixelSize(R.dimen.margin_padding_200)
            }
            7 -> {
                buttonNo.y = buttonNo.y + resources.getDimensionPixelSize(R.dimen.margin_padding_100)
            }
        }

    }

    private fun reset() {
        buttonYes.x = mX1
        buttonYes.y = mY
        buttonNo.x = mX2
        buttonNo.y = mY
    }
}
