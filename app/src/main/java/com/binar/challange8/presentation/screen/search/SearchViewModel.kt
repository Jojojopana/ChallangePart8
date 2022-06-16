package com.binar.challange8.presentation.screen.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.challange8.data.remotedata.PhotoRemoteDataSource
import com.binar.challange8.data.remotedata.PhotoRepository
import com.binar.unsplash.data.model.GetResponseItem

class SearchViewModel(private val repository: PhotoRepository): ViewModel() {
    private val searchResult : MutableLiveData<List<GetResponseItem>> by lazy { MutableLiveData<List<GetResponseItem>>() }

    fun searchResult(): LiveData<List<GetResponseItem>>{
        return searchResult
    }

    fun getSearch(query:String){
        repository.getSearch(object : PhotoRemoteDataSource.SearchResultCallBack{
            override fun onComplete(result: List<GetResponseItem>) {
                searchResult.value=result
            }
        },query)
    }

}