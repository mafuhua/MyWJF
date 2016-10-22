package com.wjf.mywjf;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.wjf.mywjf.advertis.AdvertisFragment;
import com.wjf.mywjf.apply.ApplayFragment;
import com.wjf.mywjf.base.FragmentFractory;
import com.wjf.mywjf.databinding.ActivityMainBinding;
import com.wjf.mywjf.home.MainFragment;
import com.wjf.mywjf.integral.IntegralFragment;
import com.wjf.mywjf.mine.ShopFragment;

import java.io.IOException;


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
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.setActivity(this);
        context = this;
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

        String url = Constant.SERVICE_URL + "/visit/getMeun.do?terminalType=MOBIE&os=ANDROID";
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(url)
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String s1 = response.toString();
                String s2 = String.valueOf(response.body());
                String s = response.body().toString();
                Log.d("MainActivity", s);
                Log.d("MainActivity", s1);
                Log.d("MainActivity", s2);
            }

        });
       /* XUtil.Get(url,null,new MyCallBack<String>(){

        });
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("HomeMenuPresenter", result);
                //view.onGetTiltesSuccess(result);
                Toast.makeText(WjfApplication.context, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("MainActivity", "isOnCallback:" + isOnCallback);
            }

            @Override
            public void onCancelled(org.xutils.common.Callback.CancelledException cex) {
                Log.d("MainActivity", "cex:" + cex);
            }

            @Override
            public void onFinished() {
                Log.d("MainActivity", "onFinished:");
            }
        });
*/
       /* Ion.with(this)
                .load(url)
                .asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                String code = result.get("status").getAsString();
                Gson gson = new Gson();
                Type type = new TypeToken<AppMenus>() {
                }.getType();
                AppMenus data = gson.fromJson(result.get("data"), type);
                List<HeadNav> appMenus = data.appMenus;
            }
        });*/

    }

    public void switchFragment(int id) {
        switch (id) {
            case 0:
                if (currentFragment != mainFragment) {
                    switchContent(currentFragment, mainFragment, R.id.rb_main_group);
                }
                break;
            case 1:
                switchContent(currentFragment, advertisFragment, R.id.rb_mian_advertising);
                break;
            case 2:
                switchContent(currentFragment, applayFragment, R.id.rb_mian_apply);
                break;
            case 3:
                switchContent(currentFragment, integralFragment, R.id.rb_main_integrate);
                break;
            case 4:
                switchContent(currentFragment, shopFragment, R.id.rb_main_shopping);
                break;
        }
    }

    public void switchContent(Fragment from, Fragment to, int currentcheck) {
        Toast.makeText(this, "currentcheck:" + currentcheck, Toast.LENGTH_SHORT).show();
        transaction = supportFragmentManager.beginTransaction();
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
