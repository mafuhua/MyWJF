package com.wjf.mywjf.home.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wjf.mywjf.home.HomePagerFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mTitles;

    public HomePagerAdapter(FragmentManager fm,List<String> titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        HomePagerFragment fragment = new HomePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("titles", mTitles.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    @Override
    public int getCount() {
        return 10;
    }
}
