package com.binar.challange8.data.remotedata



import com.binar.challange8.service.ApiService
import com.binar.unsplash.data.model.GetResponseItem
import kotlinx.coroutines.*

class PhotoRemoteDataSource(private val apiService: ApiService) {
    @DelicateCoroutinesApi
    fun getPhoto(photoCallBack: PhotoCallBack): List<GetResponseItem> {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.getAllPhoto()
            runBlocking(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            photoCallBack.onComplete(it)
                        }
                    }
                }
            }
        }

        return emptyList()
    }

    fun getDetailPhoto(detailCallback: DetailCallback, id: String): GetResponseItem {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.getDetail(id)
            runBlocking(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            detailCallback.onComplete(it)
                        }
                    }
                }
            }
        }
        return GetResponseItem()
    }

    fun getSearch(
        searchResultCallBack: SearchResultCallBack,
        query: String
    ): List<GetResponseItem> {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.searchPhoto(query)
            runBlocking(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            searchResultCallBack.onComplete(it.results)
                        }
                    }
                }
            }
        }

        return emptyList()
    }


    interface PhotoCallBack {
        fun onComplete(result: List<GetResponseItem>)
    }

    interface DetailCallback {
        fun onComplete(responseItem: GetResponseItem)
    }

    interface SearchResultCallBack {
        fun onComplete(result: List<GetResponseItem>)
    }
}