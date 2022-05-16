package com.grigor.epitosofttesttask.app

import android.app.Application
import com.grigor.data.di.dataLayerModules
import com.grigor.domain.di.domainLayerModules
import com.grigor.epitosofttesttask.di.presentationLayerModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EpitoSoftTestTaskApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(dataLayerModules,domainLayerModules,presentationLayerModules)
        }
    }
}