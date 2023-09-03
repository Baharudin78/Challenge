package com.baharudin.news_domain.di

import com.baharudin.news_domain.repository.NewsRepository
import com.baharudin.news_domain.use_case.GetNewsArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsDomainModule {

    @Provides
    @Singleton
    fun provideGetNewsUseCase(newsRepository: NewsRepository) : GetNewsArticleUseCase{
        return GetNewsArticleUseCase(newsRepository)
    }
}