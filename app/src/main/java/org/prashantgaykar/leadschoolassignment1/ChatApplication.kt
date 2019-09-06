package org.prashantgaykar.leadschoolassignment1

import android.app.Application
import org.prashantgaykar.leadschoolassignment1.di.component.ApplicationComponent
import org.prashantgaykar.leadschoolassignment1.di.component.DaggerApplicationComponent
import org.prashantgaykar.leadschoolassignment1.di.module.ApplicationModule

class ChatApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}