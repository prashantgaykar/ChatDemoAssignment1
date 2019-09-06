package org.prashantgaykar.leadschoolassignment1.ui.chat

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.prashantgaykar.leadschoolassignment1.data.DummyData
import org.prashantgaykar.leadschoolassignment1.data.model.Message
import org.prashantgaykar.leadschoolassignment1.data.model.MessageType
import org.prashantgaykar.leadschoolassignment1.data.repository.ChatRepository
import org.prashantgaykar.leadschoolassignment1.ui.base.BaseViewModel
import java.util.*

class ChatViewModel(private val chatRepository: ChatRepository) : BaseViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var messageList: MutableList<Message> = mutableListOf()
    val chatLiveData: MutableLiveData<MutableList<Message>> = MutableLiveData()
    var dummyMsgIdCounter = 1

    companion object {
        private const val TAG = "ChatViewModel"
    }

    override fun onCreate() {
        autoMessageFeed()
    }

    //method feeds 3 auto messages one by one with 2 seconds of interval
    private fun autoMessageFeed() {
        compositeDisposable.add(
            getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        messageList.add(it)
                        chatLiveData.postValue(messageList)
                    },
                    {
                        Log.e(TAG, "autoMessageFeed() error - $it")
                    }
                ))
    }


    private fun getObservable(): Observable<Message> = Observable.create<Message> { emitter ->
        emitter.onNext(chatRepository.getIncomingMessage(0))
        Thread.sleep(2000)
        emitter.onNext(chatRepository.getIncomingMessage(1))
        Thread.sleep(2000)
        emitter.onNext(chatRepository.getOutgoingMessage())
    }

    fun onMessageSend(newMessage: String) {
        messageList.add(
            Message(
                dummyMsgIdCounter++,
                newMessage,
                Date(),
                DummyData.dummyCurrentUser,
                MessageType.OUTGOING
            )
        )
        chatLiveData.postValue(messageList)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}