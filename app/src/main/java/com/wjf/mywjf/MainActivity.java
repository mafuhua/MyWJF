package com.wjf.mywjf;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wjf.mywjf.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewDataBinding;
    private FragmentManager supportFragmentManager;
    private MainFragment mainFragment;
    private AdvertisFragment advertisFragment;
    private ApplayFragment applayFragment;
    private IntegralFragment integralFragment;
    private ShopFragment shopFragment;
    private int currentcheck;
    private Fragment currentFragment;
    private FragmentTransaction transaction;
    private boolean isClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    public void initView() {
        currentcheck = R.id.rb_main_group;
        viewDataBinding.rgHome.check(currentcheck);
        supportFragmentManager = getSupportFragmentManager();
        mainFragment = (MainFragment) FragmentFractory.getInstance().createFragment(0);
        advertisFragment = (AdvertisFragment) FragmentFractory.getInstance().createFragment(1);
        applayFragment = (ApplayFragment) FragmentFractory.getInstance().createFragment(2);
        integralFragment = (IntegralFragment) FragmentFractory.getInstance().createFragment(3);
        shopFragment = (ShopFragment) FragmentFractory.getInstance().createFragment(4);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_home_content, mainFragment, "mainFragment")
                .add(R.id.fl_home_content, advertisFragment, "advertisFragment").hide(advertisFragment)
                .add(R.id.fl_home_content, applayFragment, "applayFragment").hide(applayFragment)
                .add(R.id.fl_home_content, integralFragment, "integralFragment").hide(integralFragment)
                .add(R.id.fl_home_content, shopFragment, "shopFragment").hide(shopFragment)
                .show(mainFragment)
                .commit();


        currentFragment = mainFragment;
    }

    public void click(View view) {
        if (view.getId() == R.id.rb_main_group) {
            if (currentFragment != mainFragment) {
                currentcheck = R.id.rb_main_group;
                switchContent(currentFragment, mainFragment, currentcheck);
            }
        } else if (view.getId() == R.id.rb_mian_advertising) {
            currentcheck = R.id.rb_main_group;
            switchContent(currentFragment, advertisFragment, currentcheck);
        } else if (view.getId() == R.id.rb_mian_apply) {
            currentcheck = R.id.rb_main_group;
            switchContent(currentFragment, applayFragment, currentcheck);
        } else if (view.getId() == R.id.rb_main_integrate) {
            currentcheck = R.id.rb_main_group;
            switchContent(currentFragment, integralFragment, currentcheck);
        } else if (view.getId() == R.id.rb_main_shopping) {
            currentcheck = R.id.rb_main_group;
            switchContent(currentFragment, shopFragment, currentcheck);
        }
    }

    public void switchContent(Fragment from, Fragment to, int currentcheck) {
        viewDataBinding.rgHome.check(currentcheck);
        currentFragment = to;
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.fl_home_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }

    @Override
    public void onBackPressed() {
        if (!isClose) {
            isClose = true;
            Toast.makeText(this, "再次点击退出应用！", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(1000);
                    isClose = false;
                }
            }).start();
        } else {
            super.onBackPressed();
        }
    }
}
