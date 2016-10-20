package com.wjf.mywjf.home;

import com.wjf.mywjf.base.BasePresenter;
import com.wjf.mywjf.base.BaseView;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HomeContract {
    interface View extends BaseView {

        void onGetTiltesSuccess(String result);

        void onGetTiltesFailure();

    }

    interface Presenter extends BasePresenter {

        void getTiltes();
    }
}
