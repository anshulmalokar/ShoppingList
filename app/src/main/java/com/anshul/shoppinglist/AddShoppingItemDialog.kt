package com.anshul.shoppinglist

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import kotlinx.android.synthetic.main.item_shopping.*
import kotlinx.android.synthetic.main.shopping_item_dialog.*

class AddShoppingItemDialog(context: Context,var itemListerner:addShoppingItemListerner): AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_item_dialog)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item=ShoppingItems(name,amount.toInt())
            itemListerner.addShoppingItem(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}