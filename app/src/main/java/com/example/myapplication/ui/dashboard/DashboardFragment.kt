package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.myapplication.R;
import com.example.myapplication.adapter.BookAdapter;
import com.example.myapplication.demo.BaseData;
import com.example.myapplication.viewmodel.model.Book;

public class DashboardFragment extends Fragment {

    private RecyclerView recyclerView;
    private DashboardViewModel dashboardViewModel;
    private BookAdapter bookAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        bookAdapter = new BookAdapter();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(bookAdapter);

        dashboardViewModel.getBookList();
        dashboardViewModel.getResult().observe(getViewLifecycleOwner(), new Observer<BaseData<Book>>() {
            @Override
            public void onChanged(BaseData<Book> book) {
                bookAdapter.setDatas(book.getData().getResult());
            }
        });
        return root;
    }
}