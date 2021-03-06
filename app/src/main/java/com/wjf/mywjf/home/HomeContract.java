package com.wjf.mywjf.home;

import com.wjf.mywjf.base.BasePresenter;
import com.wjf.mywjf.base.BaseView;
import com.wjf.mywjf.home.entity.HomeDataModule;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HomeContract {
    interface View extends BaseView {

        void onGetDataSuccess(HomeDataModule result);

        void onGetDataFailure();

    }

    interface Presenter extends BasePresenter {

        void getDatas();
    }
}
