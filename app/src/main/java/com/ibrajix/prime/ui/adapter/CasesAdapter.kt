package com.ibrajix.prime.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.RcvMainContentCasesBinding
import com.ibrajix.prime.room.Case


class CasesAdapter(private val onClickListener: OnCaseClickListener) : ListAdapter<Case, CasesAdapter.CasesViewHolder>(CasesDiffCallback()) {

    private var cardViewList = mutableListOf<CardView>()
    private var textDeliveryDateList = mutableListOf<TextView>()
    private var textFirstClientNameList = mutableListOf<TextView>()
    private var textSecondClientNameList = mutableListOf<TextView>()
    private var textGeneratedDateList = mutableListOf<TextView>()
    private var textVsList = mutableListOf<TextView>()

    class CasesViewHolder private constructor(private val binding: RcvMainContentCasesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindCase(case: Case){

            binding.txtDeliveryDate.text = case.date
            binding.txtFirstClientName.text = case.firstClientName
            binding.txtSecondClientName.text = case.secondClientName
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
            holder.bindCase(item)
        }

        if (
            !cardViewList.contains(holder.itemView.findViewById(R.id.container)) ||
            !textDeliveryDateList.contains(holder.itemView.findViewById(R.id.txt_delivery_date)) ||
            !textFirstClientNameList.contains(holder.itemView.findViewById(R.id.txt_first_client_name)) ||
            !textSecondClientNameList.contains(holder.itemView.findViewById(R.id.txt_second_client_name)) ||
            !textGeneratedDateList.contains(holder.itemView.findViewById(R.id.txt_generated_date)) ||
            !textVsList.contains(holder.itemView.findViewById(R.id.txt_vs))
        )

            {
                cardViewList.add(holder.itemView.findViewById(R.id.container))
                textDeliveryDateList.add(holder.itemView.findViewById(R.id.txt_delivery_date))
                textFirstClientNameList.add(holder.itemView.findViewById(R.id.txt_first_client_name))
                textSecondClientNameList.add(holder.itemView.findViewById(R.id.txt_second_client_name))
                textGeneratedDateList.add(holder.itemView.findViewById(R.id.txt_generated_date))
                textVsList.add(holder.itemView.findViewById(R.id.txt_vs))
        }


         holder.itemView.setOnClickListener {
             if (item != null){

                 for (cardView in cardViewList){
                     cardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.card_unselected))
                 }

                 for (txtDeliveryDate in textDeliveryDateList){
                     txtDeliveryDate.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
                 }

                 for (txtFirstClientName in textFirstClientNameList){
                     txtFirstClientName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
                 }

                 for (txtSecondClientName in textSecondClientNameList){
                     txtSecondClientName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
                 }

                 for (txtGeneratedDate in textGeneratedDateList){
                     txtGeneratedDate.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
                 }

                 for (txtVs in textVsList){
                     txtVs.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
                 }

                 holder.itemView.findViewById<CardView>(R.id.container).setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.main_orange))
                 holder.itemView.findViewById<TextView>(R.id.txt_delivery_date).setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                 holder.itemView.findViewById<TextView>(R.id.txt_first_client_name).setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                 holder.itemView.findViewById<TextView>(R.id.txt_second_client_name).setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                 holder.itemView.findViewById<TextView>(R.id.txt_generated_date).setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                 holder.itemView.findViewById<TextView>(R.id.txt_vs).setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                 onClickListener.onClickCase(item)

             }
         }
    }

    class OnCaseClickListener(val clickListener: (case: Case) -> Unit){
        fun onClickCase(case: Case) = clickListener(case)
    }

}