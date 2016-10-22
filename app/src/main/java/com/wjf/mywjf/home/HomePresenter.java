package com.wjf.mywjf.home;

import com.wjf.mywjf.Constant;
import com.wjf.mywjf.MyCallBack;
import com.wjf.mywjf.XUtil;
import com.wjf.mywjf.home.entity.HomeDataModule;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }
    @Override
    public void getDatas() {
        String  url = Constant.SERVICE_URL + Constant.ServiceConstant.NOT_LOGIN_MAIN_FRAGMENT + "?terminalType="
                + "MOBIE" + "&os=" + "ANDROID" + "&classifyId=" + 10001 + "&currentPage=" + 0 + "";
        XUtil.Get(url,null,new MyCallBack<HomeDataModule>(){
            @Override
            public void onSuccess(HomeDataModule result) {
                super.onSuccess(result);
               // Toast.makeText(WjfApplication.context, result, Toast.LENGTH_SHORT).show();
           //     Log.d("HomePresenter", result);
                view.onGetDataSuccess(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);

            }
        });

    }
}
