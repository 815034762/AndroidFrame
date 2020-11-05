package com.example.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.BookAdapter

class DashboardFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var bookAdapter: BookAdapter
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        bookAdapter = BookAdapter()
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.adapter = bookAdapter
        dashboardViewModel.getBookList()
        dashboardViewModel.getResult().observe(viewLifecycleOwner, Observer { book -> bookAdapter.setDatas(book.data.result) })
        return root
    }
}