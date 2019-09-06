package org.prashantgaykar.leadschoolassignment1.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import org.prashantgaykar.leadschoolassignment1.ChatApplication
import org.prashantgaykar.leadschoolassignment1.di.component.ActivityComponent
import org.prashantgaykar.leadschoolassignment1.di.component.DaggerActivityComponent
import org.prashantgaykar.leadschoolassignment1.di.module.ActivityModule
import javax.inject.Inject


abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent.builder()
            .applicationComponent((application as ChatApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)

    protected abstract fun setupObservers()


}

