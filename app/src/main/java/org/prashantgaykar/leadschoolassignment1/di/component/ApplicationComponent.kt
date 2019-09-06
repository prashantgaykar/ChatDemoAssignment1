package org.prashantgaykar.leadschoolassignment1.di.component

import android.content.Context
import dagger.Component
import org.prashantgaykar.leadschoolassignment1.ChatApplication
import org.prashantgaykar.leadschoolassignment1.data.local.DatabaseService
import org.prashantgaykar.leadschoolassignment1.data.remote.NetworkService
import org.prashantgaykar.leadschoolassignment1.data.repository.ChatRepository
import org.prashantgaykar.leadschoolassignment1.di.ApplicationContext
import org.prashantgaykar.leadschoolassignment1.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: ChatApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getDatabaseService(): DatabaseService

    fun getNetworkService(): NetworkService

    fun getChatRepository(): ChatRepository
}