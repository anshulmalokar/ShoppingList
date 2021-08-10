package com.anshul.shoppinglist

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [ShoppingItems::class],version = 1)
abstract class ShoppingDataBase : RoomDatabase() {
    abstract fun getShoppingDao():ShoppingDao

    companion object{
        @Volatile
        private var dataBase:ShoppingDataBase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= dataBase?: synchronized(LOCK){
            dataBase?: createDatabase(context).also {
                dataBase=it
            }
        }

        fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
            ShoppingDataBase::class.java,
            "ShoppingDB").build()
    }
}