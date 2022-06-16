@file:OptIn(DelicateCoroutinesApi::class)

package com.binar.challange8.di

import com.binar.challange8.presentation.screen.detail.DetailViewModel
import com.binar.challange8.presentation.screen.favorite.FavoriteViewModel
import com.binar.challange8.presentation.screen.home.HomeViewModel
import com.binar.challange8.presentation.screen.search.SearchViewModel
import com.binar.challange8.data.local.Favorite.FavoriteRepository
import com.binar.challange8.data.remotedata.PhotoRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.dsl.module

val repositoryModule = module {
    single {
        PhotoRepository(get())
    }
    single {
        FavoriteRepository(get())
    }
}

val viewModelModule = module {
    single {
        HomeViewModel(get())
    }
    single {
        DetailViewModel(get(),get())
    }
    single {
        SearchViewModel(get())
    }
    single {
        FavoriteViewModel(get())
    }
}