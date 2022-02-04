package com.ibrajix.prime.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.ListFragment
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.RowMenuActionItemBinding
import com.ibrajix.prime.ui.adapter.MenuListAdapter
import com.ibrajix.prime.ui.model.MenuActionItem


class MasterFragment : ListFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_master, container)
        listAdapter =
            activity?.let {
                MenuListAdapter(
                    R.layout.row_menu_action_item,
                    it,
                    MenuActionItem.values()
                )
            }
        return view
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        //I'll probably handle click events here (If necessary)
    }

}