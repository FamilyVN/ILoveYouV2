package com.tuananh.iloveyouv2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.dialog_message.view.*

/**
 * Created by FRAMGIA\vu.tuan.anh on 20/10/2017.
 */
class CustomDialog : LinearLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0, null)
    constructor(context: Context, attrs: AttributeSet?, onClickButtonListener: OnClickButtonListener?) : this(context, attrs, 0, onClickButtonListener)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, onClickButtonListener: OnClickButtonListener?) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.dialog_message, this, true)
        buttonHiHi.setOnClickListener {
            onClickButtonListener?.onDismiss()
        }
    }
}