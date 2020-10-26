package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerPagingAdapter recyclerPagingAdapter;
    private NotificationsViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        notificationsViewModel =
//                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView = root.findViewById(R.id.recycle_view);
        recyclerPagingAdapter = new RecyclerPagingAdapter();

        // 最新版本初始化 viewModel
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                .get(NotificationsViewModel.class);

        // LiveData 观察者 感应更新
        viewModel.getListLiveData().observe(getViewLifecycleOwner(), new Observer<PagedList<Notifications.ResultBean.DataBean>>() {
            @Override
            public void onChanged(PagedList<Notifications.ResultBean.DataBean> notifications) {
                // 再这里更新适配器数据
                recyclerPagingAdapter.submitList(notifications);
            }
        });

        recyclerView.setAdapter(recyclerPagingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}