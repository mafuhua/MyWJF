package com.wjf.mywjf.home.entity;

import com.wjf.mywjf.JsonResponseParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
@HttpResponse(parser = JsonResponseParser.class)
public class HeadNavMenu {


    private DataBean data;
    /**
     * data : {"appMenus":[{"classifyId":"10001","name":"推荐"},{"classifyId":"10001","name":"时尚"},{"classifyId":"10001","name":"汽车"},{"classifyId":"10001","name":"游戏"},{"classifyId":"10001","name":"购物"},{"classifyId":"10001","name":"恋爱"},{"classifyId":"10001","name":"宠物"},{"classifyId":"10001","name":"生活"}]}
     * status : ok
     */

    private String status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * classifyId : 10001
         * name : 推荐
         */

        private List<AppMenusBean> appMenus;

        public List<AppMenusBean> getAppMenus() {
            return appMenus;
        }

        public void setAppMenus(List<AppMenusBean> appMenus) {
            this.appMenus = appMenus;
        }

        public static class AppMenusBean {
            private String classifyId;
            private String name;

            public String getClassifyId() {
                return classifyId;
            }

            public void setClassifyId(String classifyId) {
                this.classifyId = classifyId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
