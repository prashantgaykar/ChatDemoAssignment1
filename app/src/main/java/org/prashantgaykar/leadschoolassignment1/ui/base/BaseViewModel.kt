package org.prashantgaykar.leadschoolassignment1.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    abstract fun onCreate()

    override fun onCleared() {
        super.onCleared()
    }
}