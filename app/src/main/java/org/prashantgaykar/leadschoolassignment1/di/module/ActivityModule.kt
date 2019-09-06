package org.prashantgaykar.leadschoolassignment1.di.module

import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import org.prashantgaykar.leadschoolassignment1.data.repository.ChatRepository
import org.prashantgaykar.leadschoolassignment1.ui.base.BaseActivity
import org.prashantgaykar.leadschoolassignment1.ui.chat.ChatViewModel
import org.prashantgaykar.leadschoolassignment1.util.ViewModelProviderFactory

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun providesChatViewModel(chatRepository: ChatRepository): ChatViewModel =
        ViewModelProviders.of(activity, ViewModelProviderFactory(ChatViewModel::class) {
            ChatViewModel(chatRepository)
        }).get(ChatViewModel::class.java)
}