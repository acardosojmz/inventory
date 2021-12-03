package dev.cardoso.quotesmvvm.core.di

import android.content.Context
import com.example.inventory.InventoryApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: InventoryApp): Context {
        return application.applicationContext
    }
}