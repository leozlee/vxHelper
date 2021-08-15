package com.example.vxhelper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WechatFragmentAdapter extends FragmentStateAdapter {

    private final int ItemCount = 2;


    public WechatFragmentAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return WechatCardFragment.newInstance(position);

    }

    @Override
    public int getItemCount() {
        return ItemCount;
    }
}
