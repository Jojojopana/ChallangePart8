package com.binar.challange8.di

import androidx.room.Room
import com.binar.challange8.data.local.Favorite.AplicationDB
import com.binar.challange8.data.local.Favorite.FavoriteLocalDataSource
import com.binar.challange8.data.remotedata.PhotoRemoteDataSource
import com.binar.challange8.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModul = module {
    single {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val photosDataSourceModule = module {
    single {
        PhotoRemoteDataSource(get())
    }
}

val favoriteDataSource = module {
    single {
        FavoriteLocalDataSource(get())
    }
}

val localModule = module {
    factory { get<AplicationDB>().favoriteDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AplicationDB::class.java,
            "MyPhoto.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}