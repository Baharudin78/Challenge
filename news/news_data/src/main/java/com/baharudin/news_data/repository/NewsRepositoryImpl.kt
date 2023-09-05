package com.baharudin.news_data.repository

import com.baharudin.news_data.local.NewsDAO
import com.baharudin.news_data.mapper.toArticle
import com.baharudin.news_data.network.NewsApiService
import com.baharudin.news_domain.model.Article
import com.baharudin.news_domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsApiService: NewsApiService,
    private val newsArticleDAO: NewsDAO
) : NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        return try {
            val loadFromLocal = newsApiService.getNewsArticle().articles.map { it.toArticle() }
            newsArticleDAO.insertList(loadFromLocal)
            newsArticleDAO.getListArticles()
        } catch (e: Exception) {
            newsArticleDAO.getListArticles()
        }
    }
}