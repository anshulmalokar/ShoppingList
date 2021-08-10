package com.anshul.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.of
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataBase=ShoppingDataBase(this)
        val repository=ShoppingRepository(dataBase)
        val factory=ViewModelFactory(repository)
        val viewModel=ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter=ShoppingRvAdapter(listOf(),viewModel)
        rvShoppingItems.adapter=adapter
        rvShoppingItems.layoutManager=LinearLayoutManager(this)

        viewModel.getAllItem().observe(this, Observer {
            adapter.listItem=it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            val dialog=AddShoppingItemDialog(this,
                object : addShoppingItemListerner {
                    override fun addShoppingItem(items: ShoppingItems) {
                        viewModel.insert(items)
                    }
                }
                )
            dialog.show()
        }
    }
}