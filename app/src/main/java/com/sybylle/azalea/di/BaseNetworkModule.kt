package com.sybylle.azalea.di

import com.sybylle.azalea.network.MangaDexApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import timber.log.Timber

val baseNetworkModule = module {
    single {
        HttpClient(Android) {
            engine {
                connectTimeout = 5_000
                socketTimeout = 5_000
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
            install(DefaultRequest) {
                header(
                    key = HttpHeaders.ContentType,
                    value = ContentType.Application.Json
                )
                url(urlString = MangaDexApi.BASE_URL)
            }
            install(ResponseObserver) {
                onResponse { response ->
                    // no-op
                }
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Timber.d(message)
                    }
                }
            }
        }
    }
}