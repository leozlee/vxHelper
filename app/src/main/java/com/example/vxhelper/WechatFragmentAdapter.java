package com.example.vxhelper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WechatFragmentAdapter extends FragmentStateAdapter {

    private final int ItemCount = 2;

    static final int VIDEO_TAB = 0;
    static final int PHOTO_TAB = 1;


    public WechatFragmentAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case VIDEO_TAB:
                return new WechatCallFragment();
            default:
                return new WechatPhotoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return ItemCount;
    }
}
