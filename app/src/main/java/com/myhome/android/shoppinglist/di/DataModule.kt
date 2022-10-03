package com.myhome.android.shoppinglist.di

import android.app.Application
import com.myhome.android.shoppinglist.data.AppDatabase
import com.myhome.android.shoppinglist.data.ShopListDao
import com.myhome.android.shoppinglist.data.ShopListRepositoryImpl
import com.myhome.android.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}