package dev.cardoso.quotesmvvm.core.di

import com.example.inventory.data.ArticleRepositoryImpl
import com.example.inventory.data.LocalDataSource
import com.example.inventory.data.LocalDataSourceImpl
import com.example.inventory.domain.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class InventoryRepositoryModule {

    @Binds
    abstract fun bindArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl):
            ArticleRepository

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl):
            LocalDataSource


}
