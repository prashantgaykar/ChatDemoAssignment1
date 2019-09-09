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
            "Big man in a suit of armor. Take that off, what are you?",
            Date(),
            DummyData.dummyUser1,
            MessageType.INCOMING
        ),
        Message(
            2,
            "Genius billionaire playboy philanthropist.",
            Date(),
            DummyData.dummyUser2,
            MessageType.INCOMING
        )
    )

    fun getDummyIncomingMessage(index: Int): Message {
        return incomingMessages[index]
    }

}