package com.baharudin.news_presentation

import com.baharudin.news_domain.model.Article

data class NewsViewState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val data : List<Article>? = emptyList()
)
