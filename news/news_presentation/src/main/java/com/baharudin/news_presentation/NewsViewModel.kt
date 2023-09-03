package com.baharudin.news_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.common_utils.network.Resource
import com.baharudin.news_domain.use_case.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsArticleUseCase
) : ViewModel() {

    private val _newsArticle = MutableStateFlow(NewsViewState())
    val newsArticle: StateFlow<NewsViewState> = _newsArticle

    init {
        getNewsArticle()
    }
    fun getNewsArticle() {
        getNewsUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _newsArticle.value = NewsViewState(isLoading = true)
                }
                is Resource.Error -> {
                    _newsArticle.value = NewsViewState(errorMessage = it.message)
                }
                is Resource.Success -> {
                    _newsArticle.value = NewsViewState(data = it.data)
                }
            }

        }.launchIn(viewModelScope)
    }
}