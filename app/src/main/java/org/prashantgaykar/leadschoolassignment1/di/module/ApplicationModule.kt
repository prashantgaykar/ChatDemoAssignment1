package org.prashantgaykar.leadschoolassignment1.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.prashantgaykar.leadschoolassignment1.ChatApplication
import org.prashantgaykar.leadschoolassignment1.di.ApplicationContext
import org.prashantgaykar.leadschoolassignment1.di.DatabaseInfo
import org.prashantgaykar.leadschoolassignment1.di.NetworkInfo
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: ChatApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDbName(): String = "chat_demo_db"

    @Provides
    @DatabaseInfo
    fun provideDbVersion(): Int = 1

    @Provides
    @NetworkInfo
    fun provideApiKey(): String = "xyz"

    @Provides
    fun provideChatRepository(): String = "xyz"
}