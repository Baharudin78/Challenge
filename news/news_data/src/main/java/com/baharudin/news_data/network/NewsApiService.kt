package com.baharudin.news_data.network

import com.baharudin.common_utils.Constant
import com.baharudin.news_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getNewsArticle(
        @Query("country") country : String = Constant.COUNTRY,
        @Query("category") category : String = Constant.CATEGORY,
        @Query("apiKey") apiKey : String = Constant.API_KEY,
    ) : NewsResponse
}