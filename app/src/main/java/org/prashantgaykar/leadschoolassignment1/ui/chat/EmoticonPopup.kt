package org.prashantgaykar.leadschoolassignment1.ui.chat

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.emoticons_layout.view.*
import org.prashantgaykar.leadschoolassignment1.R
import org.prashantgaykar.leadschoolassignment1.data.DummyData
import org.prashantgaykar.leadschoolassignment1.data.model.Emoticon

class EmoticonPopup(var context: Context) {

    private val emoticonPopupWindow = PopupWindow(context)

    init {
        initPopUp()
    }

    private fun initPopUp() {
        val popupView = LayoutInflater.from(context).inflate(R.layout.emoticons_layout, null, false)
        val container = popupView.linearLayoutEmoticonContainer
        DummyData.dummyEmoticonList.forEach { emoticon ->
            container.addView(getEmoticonUnit(emoticon))
        }
        emoticonPopupWindow.setTouchable(true)
        emoticonPopupWindow.setFocusable(true)
        emoticonPopupWindow.setOutsideTouchable(true)
        emoticonPopupWindow.setContentView(popupView)
        emoticonPopupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT)
        emoticonPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT)
        emoticonPopupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showPopupWindow(v: View) {
        emoticonPopupWindow.showAsDropDown(v, 0, v.top - (v.height * 4))
    }

    private fun toEmoticon(unicode: Int) = String(Character.toChars(unicode))

    private fun getEmoticonUnit(emoticon: Emoticon): TextView {
        val emoticonTextView = LayoutInflater.from(context).inflate(
            R.layout.emoticon_unit,
            null,
            false
        ) as TextView
        emoticonTextView.text = toEmoticon(emoticon.code)
        emoticonTextView.setOnClickListener {
            Toast.makeText(
                context, emoticon.description,
                Toast.LENGTH_SHORT
            ).show()
        }
        return emoticonTextView
    }

}