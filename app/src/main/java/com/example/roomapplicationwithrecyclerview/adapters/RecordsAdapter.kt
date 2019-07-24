package com.example.roomapplicationwithrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplicationwithrecyclerview.BR

import com.example.roomapplicationwithrecyclerview.R
import com.example.roomapplicationwithrecyclerview.database.RecordEntity
import com.example.roomapplicationwithrecyclerview.databinding.ItemLayoutBinding

class RecordsAdapter(val list:List<RecordEntity>) : RecyclerView.Adapter<RecordsAdapter.RecordHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordHolder {

        val binding: ItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_layout,parent,false)

        return RecordHolder(binding,binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecordHolder, position: Int) {
        val model:RecordEntity = list.get(position)

        holder.bind(model)
    }


    class RecordHolder(val binding:ItemLayoutBinding,itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(model: RecordEntity){

            binding.setVariable( BR.record,model)
            binding.executePendingBindings()
        }

    }
}