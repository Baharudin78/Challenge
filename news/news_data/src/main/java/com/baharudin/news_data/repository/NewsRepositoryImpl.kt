package com.baharudin.news_data.repository

import com.baharudin.news_data.mapper.toArticle
import com.baharudin.news_data.network.NewsApiService
import com.baharudin.news_domain.model.Article
import com.baharudin.news_domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsApiService: NewsApiService
) : NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        return newsApiService.getNewsArticle().articles.map {
            it.toArticle()
        }
    }
}