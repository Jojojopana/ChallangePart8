package com.binar.challange8.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.challange8.data.remotedata.PhotoRemoteDataSource
import com.binar.challange8.data.remotedata.PhotoRepository
import com.binar.unsplash.data.model.GetResponseItem
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class HomeViewModel(private val repository: PhotoRepository): ViewModel() {

    private val photo : MutableLiveData<List<GetResponseItem>> by lazy { MutableLiveData<List<GetResponseItem>>().also {
        loadPhoto()
    }}

    fun listPhoto(): LiveData<List<GetResponseItem>>{
        return photo
    }



   private fun loadPhoto(){
        repository.getPhotos(object : PhotoRemoteDataSource.PhotoCallBack{
            override fun onComplete(result: List<GetResponseItem>) {
               photo.value=result
            }

        })

    }
}