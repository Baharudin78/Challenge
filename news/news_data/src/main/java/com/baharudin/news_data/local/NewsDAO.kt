package com.baharudin.news_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baharudin.news_domain.model.Article

@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(articles : List<Article>)

    @Query("SELECT * FROM ARTICLE")
    suspend fun getListArticles() : List<Article>
}