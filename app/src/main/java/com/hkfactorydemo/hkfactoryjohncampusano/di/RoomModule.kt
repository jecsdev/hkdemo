package com.hkfactorydemo.hkfactoryjohncampusano.di

import android.content.Context
import androidx.room.Room
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.PurchaseDatabase
import com.hkfactorydemo.hkfactoryjohncampusano.data.model.Purchase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object RoomModule {
    private const val PURCHASE_DATABASE_NAME = "purchase_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PurchaseDatabase::class.java, PURCHASE_DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun providePurchaseDao(db: PurchaseDatabase) = db.getPurchaseDao()
}