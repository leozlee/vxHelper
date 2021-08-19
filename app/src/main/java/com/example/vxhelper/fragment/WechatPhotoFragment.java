package com.example.vxhelper.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vxhelper.AppContext;
import com.example.vxhelper.DataViewModel;
import com.example.vxhelper.R;
import com.example.vxhelper.adapter.CallAdapter;
import com.example.vxhelper.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

public class WechatPhotoFragment extends Fragment {

    private static String TAG = "WechatTabFragment";
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private DataViewModel dataViewModel;


    public WechatPhotoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataViewModel = new ViewModelProvider(getActivity()).get(DataViewModel.class);

        final Observer<List<String>> nameObserver = new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                photoAdapter.notifyDataSetChanged();
                Log.d(TAG, "WechatPhotoFragment update ui0000000000000000000000");
            }
        };

        dataViewModel.getData().observe(this, nameObserver);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wechat_call_tab, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AppContext.getAppContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        photoAdapter = new PhotoAdapter(dataViewModel.getData().getValue());
        recyclerView.setAdapter(photoAdapter);
    }


}
