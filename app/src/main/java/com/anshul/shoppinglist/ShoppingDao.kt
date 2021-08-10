package com.anshul.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insert(item:ShoppingItems)

    @Delete
    suspend fun delete(item:ShoppingItems)

    @Query("select * from shopping_item")
    fun getAllItems():LiveData<List<ShoppingItems>>
}