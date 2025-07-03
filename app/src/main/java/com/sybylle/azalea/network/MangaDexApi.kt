package com.sybylle.azalea.network

import com.sybylle.azalea.network.response.Collection
import com.sybylle.azalea.network.response.Manga
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface MangaDexApi {

    companion object {
        const val BASE_URL = "https://api.mangadex.org/"
    }

    suspend fun getManga(): List<Manga>
}

class MangaDexApiImpl(
    private val httpClient: HttpClient,
) : MangaDexApi {

    companion object {
        private const val GET_MANGA_PATH = "manga"
    }

    override suspend fun getManga(): List<Manga> {
        return httpClient.get(GET_MANGA_PATH)
            .body<Collection<Manga>>()
            .data
    }
}