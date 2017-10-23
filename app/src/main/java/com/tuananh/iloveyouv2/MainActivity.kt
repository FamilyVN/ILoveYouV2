package com.tuananh.iloveyouv2

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_message.view.*

class MainActivity : AppCompatActivity(), OnClickButtonListener {
    private var mAlertDialog: AlertDialog? = null
    private var mIndex = 0
    private var mX1 = 0.0f
    private var mX2 = 0.0f
    private var mY = 0.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonYes.setOnClickListener {
            createDialog("Anh biết mà, <3", R.drawable.ic_oo)
        }
        buttonNo.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    move()
                    true
                }
                else -> false
            }

        }
    }

    private fun createDialog(message: String, idIcon: Int) {
        val builder = AlertDialog.Builder(this)
        val customDialog = CustomDialog(this, null, this) as LinearLayout
        customDialog.textMessage.text = message
        customDialog.imageIcon.setImageResource(idIcon)
        builder.setView(customDialog)
        builder.setCancelable(false)
        mAlertDialog = builder.show()
    }

    private fun move() {
//        mIndex = if (mIndex < 7) mIndex + 1 else 1
        if (mIndex < 7) {
            mIndex += 1
            if (mIndex == 7) {
                createDialog("Đã nghiện lại còn ngại !", R.drawable.ic_11)
                buttonNo.visibility = View.INVISIBLE
            }
        } else {
            mIndex = 1
        }
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
        buttonNo.visibility = View.VISIBLE
    }

    override fun onDismiss() {
        mAlertDialog?.dismiss()
        mIndex = 0
        reset()
    }
}
