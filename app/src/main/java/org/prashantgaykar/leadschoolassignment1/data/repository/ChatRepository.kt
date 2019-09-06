package org.prashantgaykar.leadschoolassignment1.data.repository

import org.prashantgaykar.leadschoolassignment1.data.local.DatabaseService
import org.prashantgaykar.leadschoolassignment1.data.remote.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(val databaseService: DatabaseService, val networkService: NetworkService) {

    fun getIncomingMessage(index: Int) = networkService.getDummyIncomingMessage(index)

    fun getOutgoingMessage() = databaseService.sendDummyAutoOutgoingReply()
}