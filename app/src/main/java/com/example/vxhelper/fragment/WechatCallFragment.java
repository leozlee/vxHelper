package com.example.vxhelper.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vxhelper.AppContext;
import com.example.vxhelper.DataViewModel;
import com.example.vxhelper.OnAdapterLongClickListener;
import com.example.vxhelper.R;
import com.example.vxhelper.UserAddActivity;
import com.example.vxhelper.adapter.CallAdapter;
import com.tencent.mmkv.MMKV;

import java.util.List;

public class WechatCallFragment extends Fragment {

    private static String TAG = "WechatTabFragment";
    private RecyclerView recyclerView;
    private CallAdapter callAdapter;
    private DataViewModel dataViewModel;
    private MMKV kv = MMKV.defaultMMKV();
    private ActivityResultLauncher<Intent> Luncher;

    public WechatCallFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataViewModel = new ViewModelProvider(getActivity()).get(DataViewModel.class);
        final Observer<List<String>> nameObserver = new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                callAdapter.notifyDataSetChanged();
            }
        };
        dataViewModel.getData().observe(this, nameObserver);

        Luncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            String newPerson = result.getData().getStringExtra("name");
                            Log.d(TAG, "----------------" + newPerson);
                            if (result.getData().getStringExtra("action").equals("delete")) {
                                dataViewModel.deleteData(newPerson);
                            } else if (result.getData().getStringExtra("action").equals("renew")) {
                                dataViewModel.insertData(newPerson);
                                dataViewModel.deleteData(result.getData().getStringExtra("oldName"));
                            }
                        }

                    }
                });
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
        callAdapter.setLister(new OnAdapterLongClickListener() {
            @Override
            public void onItemLongClick(int position) {
                if (kv.decodeBool("editable")) {
                    Intent intent = new Intent(AppContext.getAppContext(), UserAddActivity.class);
                    intent.putExtra("name", dataViewModel.getData().getValue().get(position));
                    Log.d(TAG, "value is " + dataViewModel.getData().getValue().get(position));
                    Luncher.launch(intent);
                }
            }
        });
    }


}
