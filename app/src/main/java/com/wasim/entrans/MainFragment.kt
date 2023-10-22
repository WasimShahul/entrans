package com.wasim.entrans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wasim.entrans.adapter.DataAdapter
import com.wasim.entrans.data.DataDisplayType
import com.wasim.entrans.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var titleLabel: TextView
    private var displayType: DataDisplayType = DataDisplayType.VERTICAL

    companion object {
        fun newInstance(
            mainViewModel: MainViewModel,
            displayType: DataDisplayType
        ): MainFragment {
            val fragment = MainFragment()
            fragment.displayType = displayType
            fragment.mainViewModel = mainViewModel
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data_display, container, false)

        //Note: The layout manager can be customized for every view type.

        titleLabel = view.findViewById(R.id.titleLabel)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = DataAdapter()
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext())

        when (displayType) {
            DataDisplayType.VERTICAL -> {
                // Updating vertical(vertical-node) list UI
                titleLabel.text = "Vertical List"
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                recyclerView.layoutManager = layoutManager
                mainViewModel.verticalItems.observe(viewLifecycleOwner) { verticalData ->
                    adapter.submitList(verticalData)
                }
            }
            DataDisplayType.HORIZONTAL -> {
                // Updating horizontal(horizontal-node) list UI
                titleLabel.text = "Horizontal List"
                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                recyclerView.layoutManager = layoutManager
                mainViewModel.horizontalItems.observe(viewLifecycleOwner) { horizontalData ->
                    adapter.submitList(horizontalData)
                }
            }
            DataDisplayType.LIST -> {
                // Updating vertical(list-node) list UI
                titleLabel.text = "List Items"
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                recyclerView.layoutManager = layoutManager
                mainViewModel.listItems.observe(viewLifecycleOwner) { listData ->
                    adapter.submitList(listData)
                }
            }
        }

        return view
    }
}
