package com.binar.challange8.presentation.screen.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.challange8.data.local.Favorite.FavoriteLocalDataSource
import com.binar.challange8.data.local.Favorite.FavoriteRepository
import com.binar.challange8.data.local.Favorite.PhotoFavorite
import com.binar.challange8.data.remotedata.PhotoRemoteDataSource
import com.binar.challange8.data.remotedata.PhotoRepository
import com.binar.unsplash.data.model.GetResponseItem

class DetailViewModel(private val repository: PhotoRepository, private val favoriteRepository: FavoriteRepository) : ViewModel() {

    private val detailPhoto: MutableLiveData<GetResponseItem> by lazy { MutableLiveData<GetResponseItem>() }


    fun detailPhoto(): LiveData<GetResponseItem> {
        return detailPhoto
    }


    fun getDetail(id: String) {
        repository.getDetail(object : PhotoRemoteDataSource.DetailCallback {
            override fun onComplete(responseItem: GetResponseItem) {
                detailPhoto.value = responseItem
            }
        }, id)
    }

    fun addFavorite(photoFavorite: PhotoFavorite){
        favoriteRepository.addFavorite(object : FavoriteLocalDataSource.AddCallBack{
            override fun onComplete(result: Long) {
                Log.d("Dvm", result.toString())
            }
        },photoFavorite)
    }
}