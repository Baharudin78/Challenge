package com.baharudin.news_data.mapper

import com.baharudin.news_data.model.ArticleDTO
import com.baharudin.news_domain.model.Article

fun ArticleDTO.toArticle(): Article {
    return Article(
        author = this.author?:"",
        content = this.content?:"",
        description = this.description?:"",
        title = this.title?:"",
        urlToImage = this.urlToImage?:""
    )
}