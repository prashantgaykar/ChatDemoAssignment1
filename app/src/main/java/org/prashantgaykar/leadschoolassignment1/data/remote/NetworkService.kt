package org.prashantgaykar.leadschoolassignment1.data.remote

import org.prashantgaykar.leadschoolassignment1.data.DummyData
import org.prashantgaykar.leadschoolassignment1.data.model.Message
import org.prashantgaykar.leadschoolassignment1.data.model.MessageType
import org.prashantgaykar.leadschoolassignment1.di.NetworkInfo
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NetworkService @Inject constructor(@NetworkInfo var apiKey: String) {


    private val incomingMessages: List<Message> = mutableListOf(
        Message(
            1,
            "Hey there I am Prashant Gaykar, looking forward for the next round.",
            Date(),
            DummyData.dummyUser1,
            MessageType.INCOMING
        ),
        Message(
            2,
            "Hello this is Hrithik Roshan. Have you seen my movie SUPER 30 ??",
            Date(),
            DummyData.dummyUser2,
            MessageType.INCOMING
        )
    )

    fun getDummyIncomingMessage(index: Int): Message {
        return incomingMessages[index]
    }

}