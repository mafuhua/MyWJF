package com.wjf.mywjf.advertis;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.ion.Ion;
import com.wjf.mywjf.R;
import com.wjf.mywjf.WjfApplication;
import com.wjf.mywjf.databinding.FragmentAdvertisBinding;


/**
 * Created by Administrator on 2016/10/19.
 */
public class AdvertisFragment extends android.support.v4.app.Fragment {

    private FragmentAdvertisBinding fragmentAdvertisBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAdvertisBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_advertis,container, false);
        return fragmentAdvertisBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
