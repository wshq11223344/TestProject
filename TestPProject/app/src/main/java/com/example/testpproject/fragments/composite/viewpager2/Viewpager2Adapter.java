package com.example.testpproject.fragments.composite.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class Viewpager2Adapter extends FragmentStateAdapter {

    List<Fragment> mFragmentList;

    public Viewpager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);

        this.mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        if (mFragmentList != null) {

            return mFragmentList.size();
        }

        return 0;
    }



}
