package com.sybylle.android.config

import com.posthog.android.BuildConfig

object GlobalConfig {

    val isDebug: Boolean
        get() = BuildConfig.DEBUG
}