package com.hkfactorydemo.hkfactoryjohncampusano.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

@Dao
interface PurchaseDao {
    @Query("SELECT * FROM purchase_table ORDER BY id DESC")
    suspend fun getAllPurchases(): List<PurchaseEntity>

    @Insert
    suspend fun insertPurchase(purchase: PurchaseEntity)

   @Query("DELETE FROM purchase_table where :purchaseId = id")
    suspend fun deleteAllPurchases(purchaseId: Int)
}