package com.sybylle.azalea

import android.app.Application
import com.sybylle.android.config.GlobalConfig
import com.sybylle.android.config.remote.RemoteConfig
import com.sybylle.azalea.di.baseNetworkModule
import com.sybylle.azalea.di.networkModule
import com.sybylle.azalea.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class AzaleaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initRemoteConfig()
        initLogg()
    }

    private fun initKoin() {
        startKoin {
            val logLevel = if (GlobalConfig.isDebug) {
                Level.DEBUG
            } else {
                Level.NONE
            }
            androidLogger(level = logLevel)
            androidContext(androidContext = this@AzaleaApp)
            modules(
                baseNetworkModule,
                networkModule,
                viewModelModule
            )
        }
    }

    private fun initRemoteConfig() {
        RemoteConfig.init(this@AzaleaApp)
    }

    private fun initLogg() {
        if (GlobalConfig.isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}