package com.binar.challange8.service

import com.binar.unsplash.data.model.GetResponseItem
import com.binar.unsplash.data.model.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/photos/?client_id=NKqTufhAiPJc8cd5x-fCm8pW19mf5Zd1Mv5FEi2qy20")
    suspend fun searchPhoto(
        @Query("query") query: String
    ): Response<PhotoResponse>

    @GET("photos/?client_id=NKqTufhAiPJc8cd5x-fCm8pW19mf5Zd1Mv5FEi2qy20")
    suspend fun getAllPhoto(): Response<List<GetResponseItem>>

    @GET("photos/{id}/?client_id=NKqTufhAiPJc8cd5x-fCm8pW19mf5Zd1Mv5FEi2qy20")
    suspend fun getDetail(
        @Path("id") id : String
    ): Response<GetResponseItem>
}