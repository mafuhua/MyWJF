package com.wjf.mywjf.home;

import android.util.Log;
import android.widget.Toast;

import com.wjf.mywjf.Constant;
import com.wjf.mywjf.WjfApplication;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HomeService implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomeService(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getTiltes() {
        String url = Constant.SERVICE_URL + "/visit/getMeun.do?terminalType=MOBIE&os=ANDROID";
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("HomeService", result);
                view.onGetTiltesSuccess(result);
                Toast.makeText(WjfApplication.context, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
       /* XUtil.Get(url,null,new MyCallBack<AppMenus>(){
            @Override
            public void onSuccess(AppMenus result) {
                super.onSuccess(result);
                view.onGetTiltesSuccess(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);

            }
        });*/

    }
}
