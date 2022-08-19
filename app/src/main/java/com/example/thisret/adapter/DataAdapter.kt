package com.example.thisret.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thisret.R
import com.example.thisret.newModel.Data

class DataAdapter( val list: List<Data>): RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    var onItemClick :((Data) -> Unit)? = null

    inner class DataViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: Data){
            val title = itemView.findViewById<TextView>(R.id.tvTitle)
          //  val description = itemView.findViewById<TextView>(R.id.tvDescription)

            title.text = data.name
           // description.text = data.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)
        return  DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])

        }

    }

    override fun getItemCount(): Int = list.size

}