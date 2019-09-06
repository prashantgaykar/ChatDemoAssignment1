package org.prashantgaykar.leadschoolassignment1.di.component

import dagger.Component
import org.prashantgaykar.leadschoolassignment1.di.ActivityScope
import org.prashantgaykar.leadschoolassignment1.di.module.ActivityModule
import org.prashantgaykar.leadschoolassignment1.ui.chat.ChatActivity

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: ChatActivity)
}