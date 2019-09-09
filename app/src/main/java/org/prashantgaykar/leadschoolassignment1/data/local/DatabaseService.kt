package org.prashantgaykar.leadschoolassignment1.data.local

import org.prashantgaykar.leadschoolassignment1.data.DummyData
import org.prashantgaykar.leadschoolassignment1.data.model.Message
import org.prashantgaykar.leadschoolassignment1.data.model.MessageType
import org.prashantgaykar.leadschoolassignment1.di.DatabaseInfo
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabaseService @Inject constructor(@DatabaseInfo var dbName: String, @DatabaseInfo var dbVersion: Int) {


    fun sendDummyAutoOutgoingReply(): Message {
        return Message(
            1,
            "Hello, Avengers lets not fight with each other.\nSave the world together.",
            Date(),
            DummyData.dummyCurrentUser,
            MessageType.OUTGOING
        )
    }
}