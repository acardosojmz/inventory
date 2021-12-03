package com.example.inventory.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inventory.data.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDAO {
    @Query("SELECT * FROM article ORDER BY price ASC")
    fun getAll(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE id = :articleId")
    fun getArticle(articleId: Int): Flow<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addArticle(article: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun addAll(article: List<ArticleEntity>)

    @Query("DELETE FROM article")
    suspend fun deleteAll()

    @Query("DELETE FROM article WHERE id=:articleId ")
    suspend fun delete(articleId: Int)

}
