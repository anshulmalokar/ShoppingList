package com.anshul.shoppinglist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
class ShoppingItems(
    @ColumnInfo(name="item_name")
    var name:String,
    @ColumnInfo(name="item_amount")
    var amount:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}