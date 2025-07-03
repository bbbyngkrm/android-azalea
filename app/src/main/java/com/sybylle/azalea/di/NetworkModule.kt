package com.sybylle.azalea.di

import com.sybylle.azalea.network.MangaDexApi
import com.sybylle.azalea.network.MangaDexApiImpl
import org.koin.dsl.module

val networkModule = module {
    factory<MangaDexApi> { MangaDexApiImpl(get()) }
}