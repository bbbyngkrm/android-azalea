package com.sybylle.android.config

import com.sybylle.azalea.BuildConfig

object GlobalConfig {

    val isDebug: Boolean
        get() = BuildConfig.DEBUG
}