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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vxhelper.AppContext;
import com.example.vxhelper.DataViewModel;
import com.example.vxhelper.R;
import com.example.vxhelper.adapter.CallAdapter;

import java.util.List;

public class WechatCallFragment extends Fragment {

    private static String TAG = "WechatTabFragment";

    private static final String ARG_COUNT = "param1";
    private Integer counter;
    private RecyclerView recyclerView;
    private CallAdapter callAdapter;

    private DataViewModel dataViewModel;

    public WechatCallFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }

        dataViewModel = new ViewModelProvider(getActivity()).get(DataViewModel.class);

        final Observer<List<String>> nameObserver = new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                callAdapter.notifyDataSetChanged();

                Log.d(TAG, "11111111111111111111111111");

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppContext.getAppContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        callAdapter = new CallAdapter(dataViewModel.getData().getValue());
        recyclerView.setAdapter(callAdapter);
    }


}
