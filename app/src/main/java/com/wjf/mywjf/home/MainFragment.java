package com.wjf.mywjf.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wjf.mywjf.MainActivity;
import com.wjf.mywjf.R;
import com.wjf.mywjf.databinding.FragmentHomeBinding;
import com.wjf.mywjf.home.adapter.HeadIndicatorAdapter;
import com.wjf.mywjf.home.adapter.HomePagerAdapter;
import com.wjf.mywjf.home.entity.AppMenus;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
public class MainFragment extends Fragment implements HomeContract.View{

    private FragmentHomeBinding fragmentHomeBinding;
    private AppMenus appMenus;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        fragmentHomeBinding.rvHeadIndicator.setLayoutManager(linearLayoutManager);
        //设置适配器
        HeadIndicatorAdapter headIndicatorAdapter = new HeadIndicatorAdapter(appMenus);
        fragmentHomeBinding.rvHeadIndicator.setAdapter(headIndicatorAdapter);
        List<String> list = Arrays.asList( new String[]{"111","111","111","111","111","111","111","111","111","111","111"});
        fragmentHomeBinding.vpHome.setAdapter(new HomePagerAdapter(getFragmentManager(),list));
        HomeService homeService = new HomeService(this);
        homeService.getTiltes();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container, false);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onGetTiltesSuccess(String result) {

        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();

       // fragmentHomeBinding.rvHeadIndicator.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onGetTiltesFailure() {

    }
}
