package org.prashantgaykar.leadschoolassignment1.ui.chat

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_chat.*
import org.prashantgaykar.leadschoolassignment1.R
import org.prashantgaykar.leadschoolassignment1.data.DummyData
import org.prashantgaykar.leadschoolassignment1.data.model.Message
import org.prashantgaykar.leadschoolassignment1.di.component.ActivityComponent
import org.prashantgaykar.leadschoolassignment1.ui.base.BaseActivity


class ChatActivity : BaseActivity<ChatViewModel>() {
    lateinit var chatMessageAdapter: ChatMessageAdapter
    private var messageList: MutableList<Message> = mutableListOf()

    override fun provideLayoutId() = R.layout.activity_main

    override fun setupObservers() {
        viewModel.chatLiveData.observe(this, Observer {
            chatMessageAdapter.setList(it)
            chatMessageAdapter.notifyItemInserted(it.size)
            recyclerViewChat.smoothScrollToPosition(it.size)
        })
    }

    fun getDummyNames() = "${DummyData.dummyUser1.firstName},${DummyData.dummyUser2.firstName}"

    override fun setupView(savedInstanceState: Bundle?) {
        setUpToolbar(getString(R.string.chat_group), getDummyNames())
        editTextMessage.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (v.text.trim().isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.please_enter_message),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    false
                } else {
                    viewModel.onMessageSend(v.text.toString())
                    v.text = ""
                    true
                }
            } else {
                false
            }
        }
        chatMessageAdapter = ChatMessageAdapter(messageList, this)
        recyclerViewChat.adapter = chatMessageAdapter
        recyclerViewChat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        imgBtnAdd.setOnClickListener { v ->
            Toast.makeText(
                applicationContext, getString(R.string.attachment),
                Toast.LENGTH_SHORT
            ).show()
        }

        imgBtnMic.setOnClickListener { v ->
            Toast.makeText(
                applicationContext, getString(R.string.record_audio),
                Toast.LENGTH_SHORT
            ).show()
        }

        imgBtnCamera.setOnClickListener { v ->
            Toast.makeText(
                applicationContext, getString(R.string.take_photo),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun setUpToolbar(title: String, subtitle: String) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar?.let {
            setSupportActionBar(it)
            it.title = title
            it.subtitle = subtitle
            it.setNavigationIcon(R.drawable.ic_go_back)
            it.setNavigationOnClickListener { v -> finish() }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_video_call -> {
                Toast.makeText(
                    applicationContext, getString(R.string.video_call),
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.action_call -> {
                Toast.makeText(
                    applicationContext, getString(R.string.audio_call),
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
