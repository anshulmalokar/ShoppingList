package com.anshul.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shopping.view.*

class ShoppingRvAdapter(var listItem:List<ShoppingItems>, private val viewModel:ShoppingViewModel): RecyclerView.Adapter<ShoppingRvAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_shopping,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.itemView.apply {
            tvName.text=listItem[position].name
            tvAmount.text=listItem[position].amount.toString()

            ivDelete.setOnClickListener{
                viewModel.delete(listItem[position])
            }

            ivPlus.setOnClickListener {
                listItem[position].amount++
                viewModel.insert(listItem[position])
            }

            ivMinus.setOnClickListener {
                if(listItem[position].amount>0){
                    listItem[position].amount--;
                    viewModel.insert(listItem[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}