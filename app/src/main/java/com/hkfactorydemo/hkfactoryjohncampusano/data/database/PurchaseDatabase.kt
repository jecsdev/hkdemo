package com.hkfactorydemo.hkfactoryjohncampusano.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.dao.PurchaseDao
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

@Database(entities = [PurchaseEntity::class], version = 2)
abstract class PurchaseDatabase: RoomDatabase() {
    abstract fun getPurchaseDao(): PurchaseDao
}