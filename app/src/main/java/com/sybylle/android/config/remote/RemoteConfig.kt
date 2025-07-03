package com.sybylle.android.config.remote

import android.content.Context
import com.posthog.PostHog
import com.posthog.android.PostHogAndroid
import com.posthog.android.PostHogAndroidConfig
import com.sybylle.azalea.BuildConfig

object RemoteConfig {

    fun init(context: Context) {
        val config = PostHogAndroidConfig(
            apiKey = BuildConfig.POSTHOG_API_KEY,
            host = BuildConfig.POSTHOG_HOST
        )
        PostHogAndroid.setup(context, config)
    }

    fun getFeatureFlag(key: String, defaultValue: Any? = null) : Any? {
        return PostHog.getFeatureFlag(key, defaultValue)
    }
}