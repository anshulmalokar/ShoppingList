package com.anshul.shoppinglist

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {
    fun insert(items: ShoppingItems)= GlobalScope.launch(Dispatchers.IO) {
        repository.insert(items)
    }
    fun delete(items: ShoppingItems)=GlobalScope.launch(Dispatchers.IO) {
        repository.delete(items)
    }
    fun getAllItem()=repository.getAllItems()
}