package com.baharudin.challange.di

import android.content.Context
import com.baharudin.challange.database.AppDatabase
import com.baharudin.challange.navigator.DefaultNavigator
import com.baharudin.common_utils.Navigator
import com.baharudin.news_data.local.NewsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNavProvider() : Navigator.NavigatorProvider{
        return DefaultNavigator()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context : Context) : AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideNewsDAO(appDatabase : AppDatabase) : NewsDAO {
        return appDatabase.getNewsArticleDAO()
    }

}