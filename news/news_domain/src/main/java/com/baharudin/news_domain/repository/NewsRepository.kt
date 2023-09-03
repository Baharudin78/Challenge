package com.baharudin.news_domain.repository

import com.baharudin.news_domain.model.Article

interface NewsRepository {
    suspend fun getNewsArticle() : List<Article>
}