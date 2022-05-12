package com.hkfactorydemo.hkfactoryjohncampusano.data.database

import androidx.room.Database
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.dao.PurchaseDao
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

@Database(entities = [PurchaseEntity::class], version = 1)
abstract class PurchaseDatabase {
    abstract fun getPurchaseDao(): PurchaseDao
}