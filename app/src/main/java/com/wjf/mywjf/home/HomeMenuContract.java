package com.wjf.mywjf.home;

import com.wjf.mywjf.base.BasePresenter;
import com.wjf.mywjf.base.BaseView;
import com.wjf.mywjf.home.entity.HeadNavMenu;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HomeMenuContract {
    interface View extends BaseView {

        void onGetTiltesSuccess(HeadNavMenu result);

        void onGetTiltesFailure();

    }

    interface Presenter extends BasePresenter {

        void getTiltes();
    }
}
