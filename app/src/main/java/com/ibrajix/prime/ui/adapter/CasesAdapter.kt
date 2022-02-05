package com.ibrajix.prime.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrajix.prime.databinding.RcvMainContentCasesBinding
import com.ibrajix.prime.room.Case

class CasesAdapter() : ListAdapter<Case, CasesAdapter.CasesViewHolder>(CasesDiffCallback()) {

    class CasesViewHolder private constructor(private val binding: RcvMainContentCasesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindCase(case: Case){
            binding.txtDeliveryDate.text = case.date
            binding.txtFirstClientName.text = case.firstClientName
            binding.txtSecondClientName.text = case.firstClientName
            binding.txtGeneratedDate.text = case.genId
        }

        companion object{
            fun from(parent: ViewGroup) : CasesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RcvMainContentCasesBinding.inflate(layoutInflater, parent, false)
                return CasesViewHolder(binding)
            }
        }
    }

    class CasesDiffCallback : DiffUtil.ItemCallback<Case>(){

        override fun areItemsTheSame(oldItem: Case, newItem: Case): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Case, newItem: Case): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasesViewHolder {
        return CasesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CasesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bindCase(item)

        }
    }

}