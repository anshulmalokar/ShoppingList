package com.anshul.shoppinglist

class ShoppingRepository(private val dataBase: ShoppingDataBase) {
    suspend fun insert(item:ShoppingItems)=dataBase.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItems)=dataBase.getShoppingDao().delete(item)

    fun getAllItems()=dataBase.getShoppingDao().getAllItems()
}