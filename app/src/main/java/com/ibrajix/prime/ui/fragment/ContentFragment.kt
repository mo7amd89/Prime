package com.ibrajix.prime.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.FragmentContentBinding
import com.ibrajix.prime.ui.adapter.CasesAdapter
import com.ibrajix.prime.ui.viewModel.DatabaseViewModel
import com.ibrajix.prime.utils.RecyclerItemDecoration
import com.ibrajix.prime.utils.Utility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
@SuppressLint("UnsafeRepeatOnLifecycleDetector")
class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null
    private val binding get() = _binding!!

    private val databaseViewModel: DatabaseViewModel by viewModels()

    private lateinit var casesAdapter: CasesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){

        val fragmentView = activity?.findViewById<FragmentContainerView>(R.id.nav_host_fragment)
        val detailView = activity?.findViewById<ConstraintLayout>(R.id.lyt_detail)

        val closeButton = activity?.findViewById<AppCompatButton>(R.id.close)

        closeButton?.setOnClickListener {
            fragmentView?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.content_background))
            binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.content_background))
            detailView?.visibility = View.GONE
        }

        casesAdapter = CasesAdapter(CasesAdapter.OnCaseClickListener{
            fragmentView?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fragment_view_when_clicked))
            binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fragment_view_when_clicked))
            detailView?.visibility = View.VISIBLE
        })

        insertAndGetData()
        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){

        val numberOfColumns = Utility.calculateNoOfColumns(requireContext(), 300)
        val rcvItemDecoration = RecyclerItemDecoration(numberOfColumns, 20)
        binding.rcvCases.apply {
            adapter = casesAdapter
            layoutManager = GridLayoutManager(requireContext(), numberOfColumns)
            addItemDecoration(rcvItemDecoration)
        }

    }


    private fun insertAndGetData(){

        //first, insert list of cases
        databaseViewModel.createCases()

        //get the list of cases
        databaseViewModel.getAllListCases()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                databaseViewModel.getAllCases.collect {
                    casesAdapter.submitList(it)
                }
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}