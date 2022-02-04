package com.ibrajix.prime.ui.adapter


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.ibrajix.prime.R
import com.ibrajix.prime.ui.model.MenuActionItem


class MenuListAdapter(var resource: Int, var activity: Activity, items: Array<MenuActionItem>) : ArrayAdapter<MenuActionItem>(activity, resource, items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var rowView: View? = convertView

        if (rowView == null){
            rowView = activity.layoutInflater.inflate(resource, null)
            val viewHolder = MenuItemViewHolder()
            viewHolder.menuItemImageView = rowView.findViewById(R.id.menu_item_image_view) as ImageView
            viewHolder.menuItemTextView = rowView.findViewById(R.id.menu_item_text_view)
            rowView.tag = viewHolder
        }
        val holder = rowView?.tag as MenuItemViewHolder

        when(position) {
            MenuActionItem.ITEM1.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_dashboard))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.dashboard)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM2.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_plus_square))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.latest_judgements)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.selected_tab))
            }
            MenuActionItem.ITEM3.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_briefcase))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.law_reports)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM4.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_book_open))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.laws_of_nigeria)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM5.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_harmburger_2))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.civil_procedure_rules)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM6.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_inbox))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.index_digest)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM7.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_edit))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.textbook_journals)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM8.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_folder))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.research_folder)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM9.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_award))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.words_in_gold)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
            MenuActionItem.ITEM10.ordinal -> {
                holder.menuItemImageView?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_plus_square_2))
                holder.menuItemTextView?.text = activity.resources.getString(R.string.new_contents)
                holder.menuItemTextView?.setTextColor(ContextCompat.getColor(context, R.color.unselected_tab))
            }
        }
        return rowView
    }


    private class MenuItemViewHolder {
        var menuItemImageView: ImageView? = null
        var menuItemTextView: TextView? = null
    }



}