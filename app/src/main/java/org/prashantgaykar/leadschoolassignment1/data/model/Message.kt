package org.prashantgaykar.leadschoolassignment1.data.model

import java.util.*

data class Message(

    var id: Int,
    var message: String,
    var dateTime: Date,
    var user: User,
    var messageType: MessageType

)