package org.prashantgaykar.leadschoolassignment1.data

import org.prashantgaykar.leadschoolassignment1.data.model.Emoticon
import org.prashantgaykar.leadschoolassignment1.data.model.User

object DummyData {

    val dummyCurrentUser = User(3, "YourFirstName", "YourLastName", "#000000", "#FFFFFF")
    val dummyUser1 = User(1, "Prashant", "Gaykar", "#3f51b5", "#FFFFFF")
    val dummyUser2 = User(2, "Hrithik", "Roshan", "#f44336", "#FFFFFF")

    val dummyEmoticonList: MutableList<Emoticon> = mutableListOf(
        Emoticon(0x1F600, "grinning face"),
        Emoticon(0x1F603, "grinning face with big eyes"),
        Emoticon(0x1F604, "grinning face with smiling eyes"),
        Emoticon(0x1F601, "beaming face with smiling eyes"),
        Emoticon(0x1F606, "grinning squinting face"),
        Emoticon(0x1F605, "grinning face with sweat"),
        Emoticon(0x1F923, "rolling on the floor laughing"),
        Emoticon(0x1F602, "face with tears of joy"),
        Emoticon(0x1F642, "slightly smiling face"),
        Emoticon(0x1F643, "upside-down face"),
        Emoticon(0x1F609, "winking face")
    )
}