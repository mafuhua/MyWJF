package com.wjf.mywjf;

import android.content.Context;

import com.wjf.mywjf.base.BasePresenter;
import com.wjf.mywjf.base.BaseView;

public interface MeContract {

    interface View extends BaseView {



        void showError();

        void showEmptyData();

        void lanuchDetail(Integer taskId);

        void onTaskStatusChange(Integer taskId, Integer status,Integer oldStatus);

        void onTaskStatusChangeFailure(Integer taskId, Integer status,Integer oldStatus);
    }

    interface Presenter extends BasePresenter {

        /**
         * 请求任务列表
         *
         * @param title    检索消息标题
         * @param pagenum  请求的页码
         * @param pagesize 每页大小
         * @param start    筛选日程起始时间
         * @param end      筛选日程截止时间
         * @param emg      筛选紧急程度 0、一般 ；1、紧急
         * @param order    结果排序  0、默认 1、优先级最高 2、即将结束
         * @param state    任务状态id 0、未完成 1、已完成 2、已过期 3、已取消
         */
        void requestTasks(Context context, String title
                , Long pagenum
                , Long pagesize
                , Long start
                , Long end
                , Integer emg
                , String order
                , Integer state
                , Integer version);

        /**
         * 刷新任务列表
         *
         * @param title 检索消息标题
         * @param start 筛选日程起始时间
         * @param end   筛选日程截止时间
         * @param emg   筛选紧急程度 0、一般 ；1、紧急
         * @param order 结果排序
         * @param state 任务状态id 0、未完成 1、已完成 2、已过期 3、已取消
         */
        void refresh(Context context,String title
                , Long start
                , Long end
                , Integer emg
                , String order
                , Integer state
                ,Integer version
        );

        /**
         * 设置任务状态
         *
         * @param taskId 任务id
         * @param status 状态
         */
        void setTaskStatus(Integer taskId, Integer status,Integer oldStatus);
    }
}
