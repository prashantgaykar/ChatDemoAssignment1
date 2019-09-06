package org.prashantgaykar.leadschoolassignment1.ui.chat

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chat_unit.view.*
import org.prashantgaykar.leadschoolassignment1.R
import org.prashantgaykar.leadschoolassignment1.data.model.Message
import org.prashantgaykar.leadschoolassignment1.data.model.MessageType
import org.prashantgaykar.leadschoolassignment1.util.DateUtil

class ChatMessageAdapter(var messages: MutableList<Message>, val context: Context) :
    RecyclerView.Adapter<ChatMessageAdapter.ChatMessageViewHolder>() {

    var emoticonPopup: EmoticonPopup = EmoticonPopup(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatMessageViewHolder {
        return ChatMessageViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.chat_unit,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = messages.size

    fun setList(messages: MutableList<Message>) {
        this.messages = messages
    }

    override fun onBindViewHolder(holder: ChatMessageViewHolder, position: Int) {
        if (messages[position].messageType == MessageType.INCOMING) {
            val incomingMessage = messages[position]
            showIncomingMessageOnly(holder)
            holder.textViewIncomingMsg.text = incomingMessage.message
            holder.textViewIncomingMsgInfo.text = buildIncomingMsgInfoText(incomingMessage)
            holder.textViewNameInitials.text = buildNameInitials(incomingMessage)
            setNameInitialsAndColor(holder.textViewNameInitials, incomingMessage)
            holder.imgViewEmoticon.setOnClickListener { v -> emoticonPopup.showPopupWindow(v) }
        } else {
            showOutgoingMessageOnly(holder)
            val outgoingMessage = messages[position]
            holder.textViewOutgoingMsg.text = outgoingMessage.message
            holder.textViewOutgoingMsgInfo.text = buildOutgoingMsgInfoText(outgoingMessage)
        }
    }

    private fun buildIncomingMsgInfoText(message: Message) =
        "${message.user.firstName} ${message.user.lastName}, ${DateUtil.convertTo12HourTimeString(
            message.dateTime
        )}"

    private fun buildOutgoingMsgInfoText(message: Message) =
        DateUtil.convertTo12HourTimeString(message.dateTime)

    private fun buildNameInitials(message: Message) =
        "${message.user.firstName.toUpperCase()[0]}${message.user.lastName.toUpperCase()[0]}"

    private fun setNameInitialsAndColor(textView: TextView, message: Message) {
        textView.setTextColor(Color.parseColor(message.user.textColor))
        val drawable: GradientDrawable = textView.background as GradientDrawable
        drawable.color = ColorStateList.valueOf(Color.parseColor(message.user.backgroundColor))
    }


    private fun showIncomingMessageOnly(holder: ChatMessageViewHolder) =
        setVisibility(holder, true, false)

    private fun showOutgoingMessageOnly(holder: ChatMessageViewHolder) =
        setVisibility(holder, false, true)

    private fun setVisibility(
        holder: ChatMessageViewHolder,
        showIncoming: Boolean,
        showOutgoing: Boolean
    ) {
        holder.textViewIncomingMsg.visibility = if (showIncoming) View.VISIBLE else View.INVISIBLE
        holder.textViewIncomingMsgInfo.visibility =
            if (showIncoming) View.VISIBLE else View.INVISIBLE
        holder.imgViewEmoticon.visibility = if (showIncoming) View.VISIBLE else View.INVISIBLE
        holder.textViewNameInitials.visibility = if (showIncoming) View.VISIBLE else View.INVISIBLE
        holder.textViewOutgoingMsg.visibility = if (showOutgoing) View.VISIBLE else View.INVISIBLE
        holder.textViewOutgoingMsgInfo.visibility =
            if (showOutgoing) View.VISIBLE else View.INVISIBLE
    }

    class ChatMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewIncomingMsg = view.textViewIncomingMessage
        val textViewIncomingMsgInfo = view.textViewIncomingMessageInfo
        val textViewOutgoingMsg = view.textViewOutgoingMessage
        val textViewOutgoingMsgInfo = view.textViewOutgoingMessageInfo
        val textViewNameInitials = view.textViewNameInitials
        val imgViewEmoticon = view.imgViewEmoticon
    }
}