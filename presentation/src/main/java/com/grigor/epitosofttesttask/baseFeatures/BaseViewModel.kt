package com.grigor.epitosofttesttask.baseFeatures

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel


abstract class BaseViewModel<IN> : ViewModel() {

    private val _baseIntentChanel = Channel<IN>(Channel.UNLIMITED)
     val baseIntentChannel get() = _baseIntentChanel

}