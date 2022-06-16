package com.binar.challange8.data.remotedata

import com.binar.challange8.data.remotedata.PhotoRemoteDataSource
import com.binar.unsplash.data.model.GetResponseItem
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class PhotoRepository constructor(private val photoRemoteDataSource: PhotoRemoteDataSource){
    fun getPhotos(photoCallBack: PhotoRemoteDataSource.PhotoCallBack):List<GetResponseItem>{
        return photoRemoteDataSource.getPhoto(photoCallBack)
    }

   fun getDetail (detailCallback: PhotoRemoteDataSource.DetailCallback, id: String): GetResponseItem{
        return photoRemoteDataSource.getDetailPhoto(detailCallback,id)
    }

    fun getSearch(searchResultCallBack: PhotoRemoteDataSource.SearchResultCallBack, query:String):List<GetResponseItem>{
        return photoRemoteDataSource.getSearch(searchResultCallBack,query)
    }
}