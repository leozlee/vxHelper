package com.example.vxhelper;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WechatMainFragment extends Fragment {

    private final String[] TabName = {"视频通话", "朋友圈"};
    private final int[] icon = {R.drawable.voice, R.drawable.camera};
    private WechatFragmentAdapter adapter;
    private boolean editAble = false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new WechatFragmentAdapter(this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wechat, container, false);
        TabLayout tabLayout = root.findViewById(R.id.tabs);
        ViewPager2 viewPager = root.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(TabName[position]);
                        tab.setIcon(icon[position]);
                    }
                }).attach();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_add: {
                        Intent intent = new Intent(AppContext.getAppContext(), UserAddActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.menu_open_setting:
                        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                        startActivity(intent);
                        break;
                    case R.id.action_about:

                        break;
                    case R.id.editable:
                        editAble = !editAble;
                        item.setChecked(editAble);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }


}
