package com.baharudin.news_data.network

import com.baharudin.news_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getNewsArticle(
        @Query("country") country : String,
        @Query("category") category : String,
        @Query("apiKey") apiKey : String,
    ) : NewsResponse
}