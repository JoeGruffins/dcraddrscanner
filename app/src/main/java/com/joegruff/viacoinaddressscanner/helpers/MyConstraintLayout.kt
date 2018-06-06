package com.joegruff.viacoinaddressscanner.helpers

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.joegruff.viacoinaddressscanner.R
import kotlinx.android.synthetic.main.balance_swirl.view.*
import org.json.JSONObject
import org.json.JSONTokener

class MyConstraintLayout : RelativeLayout, AsyncObserver {
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context,attrs,defStyleAttr)
    constructor(context: Context, attrs: AttributeSet) : super(context,attrs)
    constructor(context: Context) : super(context)


    override fun processbegan() {
        balance_swirl_progress_bar.alpha = 0.7f
    }

    override fun processfinished(output: String?) {


        if (output != null) {
            val token = JSONTokener(output).nextValue()

            if (token is JSONObject) {
                val amountString = token.getString("balance")
                balance_swirl_progress_bar.alpha = 0f
                balance_swirl_balance.setText(amountString)
                Log.d("constraintlayout ", "process finished" + output)
            }
        }

    }
}