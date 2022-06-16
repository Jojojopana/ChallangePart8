package com.binar.unsplash.data.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("results")
    val results: List<GetResponseItem>,
)