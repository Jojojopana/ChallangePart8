package com.binar.unsplash.data.model


import com.google.gson.annotations.SerializedName

data class GetResponseItem(
    @SerializedName("alt_description")
    val altDescription: String?=null,
    @SerializedName("blur_hash")
    val blurHash: String?=null,
    @SerializedName("categories")
    val categories: List<Any>?=null,
    @SerializedName("color")
    val color: String?=null,
    @SerializedName("created_at")
    val createdAt: String?=null,
    @SerializedName("current_user_collections")
    val currentUserCollections: List<Any>?=null,
    @SerializedName("description")
    val description: String?=null,
    @SerializedName("height")
    val height: Int?=null,
    @SerializedName("id")
    val id: String?=null,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean?=null,
    @SerializedName("likes")
    val likes: Int?=null,
    @SerializedName("links")
    val links: Links?=null,
    @SerializedName("promoted_at")
    val promotedAt: String?=null,
    @SerializedName("sponsorship")
    val sponsorship: Sponsorship?=null,
    @SerializedName("topic_submissions")
    val topicSubmissions: TopicSubmissions?=null,
    @SerializedName("updated_at")
    val updatedAt: String?=null,
    @SerializedName("urls")
    val urls: Urls?=null,
    @SerializedName("user")
    val user: User?=null,
    @SerializedName("width")
    val width: Int?=null
)