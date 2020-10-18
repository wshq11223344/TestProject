package com.example.testpproject.fragments.composite;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> mFragmentList;

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.mFragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {

        if (mFragmentList != null) {

            return mFragmentList.size();
        }

        return 0;
    }
}
