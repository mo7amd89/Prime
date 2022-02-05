package com.ibrajix.prime.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.RcvMainContentCasesBinding
import com.ibrajix.prime.room.Case


class CasesAdapter : ListAdapter<Case, CasesAdapter.CasesViewHolder>(CasesDiffCallback()) {

    var rowPosition = -1

    private var cardViewList = mutableListOf<CardView>()

    class CasesViewHolder private constructor(private val binding: RcvMainContentCasesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindCase(case: Case, holder: CasesViewHolder){

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

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: CasesViewHolder, position: Int) {

        val item = getItem(position)

        if (item != null){
            holder.bindCase(item, holder)
        }

        if (!cardViewList.contains(holder.itemView.findViewById(R.id.container))) {
            cardViewList.add(holder.itemView.findViewById(R.id.container))
        }


        holder.itemView.findViewById<CardView>(R.id.container).setOnClickListener{
            for (cardView in cardViewList){
                cardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.card_unselected))
            }
            holder.itemView.findViewById<CardView>(R.id.container).setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.main_orange))
        }


        /* holder.itemView.setOnClickListener {
             if (item != null){
                 onClickListener.onClickCase(item)
             }
         }*/
    }

    /*class OnCaseClicked(val clickListener: (case: Case) -> Unit){
        fun onClickCase(case: Case) = clickListener(case)
    }*/

}