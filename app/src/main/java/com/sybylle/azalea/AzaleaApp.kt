package com.sybylle.azalea

import android.app.Application
import com.sybylle.android.config.remote.RemoteConfig

class AzaleaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initRemoteConfig()
    }

    private fun initRemoteConfig() {
        RemoteConfig.init(this@AzaleaApp)
    }
}