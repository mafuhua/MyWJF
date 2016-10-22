package com.wjf.mywjf.home;

import com.wjf.mywjf.Constant;
import com.wjf.mywjf.MyCallBack;
import com.wjf.mywjf.XUtil;
import com.wjf.mywjf.home.entity.HeadNavMenu;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HomeMenuPresenter implements HomeMenuContract.Presenter {
    private HomeMenuContract.View view;

    public HomeMenuPresenter(HomeMenuContract.View view) {
        this.view = view;
    }
    @Override
    public void getTiltes() {
        String url = Constant.SERVICE_URL + "/visit/getMeun.do?terminalType=MOBIE&os=ANDROID";
        XUtil.Get(url,null,new MyCallBack<HeadNavMenu>(){
            @Override
            public void onSuccess(HeadNavMenu result) {
                super.onSuccess(result);
                view.onGetTiltesSuccess(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);

            }
        });

    }
}
