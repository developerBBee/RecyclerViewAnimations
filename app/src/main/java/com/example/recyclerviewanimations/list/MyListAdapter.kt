package com.example.recyclerviewanimations.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimations.databinding.ListItemBinding

class MyListAdapter : RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {
    private val items: MutableList<MyItem> = mutableListOf()

    fun addItem(item: MyItem) {
        items.add(0, item)
        notifyItemInserted(0)
    }

    private fun removeItem(item: MyItem) {
        val position = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(item = items[position], removeItem = ::removeItem)
    }

    class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MyItem, removeItem: (MyItem) -> Unit) {
            binding.listItemTitle.text = item.title
            binding.listItemDescription.text = item.description
            binding.listItemDelete.setOnClickListener { removeItem(item) }
        }
    }
}