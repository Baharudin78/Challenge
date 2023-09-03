package com.baharudin.challange.di

import com.baharudin.challange.navigator.DefaultNavigator
import com.baharudin.common_utils.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}