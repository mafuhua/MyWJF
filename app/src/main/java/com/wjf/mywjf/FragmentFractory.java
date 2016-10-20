package com.wjf.mywjf;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * fragment工厂类
 *
 * @author wangdh
 */
public class FragmentFractory {

    private static FragmentFractory instance = new FragmentFractory();
    private HashMap<Integer, Fragment> cacheFragment = new HashMap<Integer, Fragment>();

    private FragmentFractory() {
    }

    public static FragmentFractory getInstance() {
        return instance;
    }

    //根据当前位置获取对应的fragment
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        fragment = cacheFragment.get(position);
        if (fragment == null) {
            if (position == 0) {//首页
                fragment = new MainFragment();
            } else if (position == 1) {//广告
                fragment = new AdvertisFragment();
            } else if (position == 2) {//应用
                 fragment = new ApplayFragment();
            } else if (position == 3) {//积分
                fragment = new IntegralFragment();
            }else if (position == 4) {//我的
                fragment = new ShopFragment();
            }
            cacheFragment.put(position, fragment);
        }


        return fragment;
    }
}