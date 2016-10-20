package com.wjf.mywjf;

public class Constant {

    //服务器长量
//    public static final String SERVICE_URL = "http://192.168.1.157:8203/LvScore_Service";

   // public static final String SERVICE_URL = "http://119.255.40.206:8203/LvScore_Service";

    public static final String SERVICE_URL = "http://114.112.104.151:8203/LvScore_Service";
    public class ServiceConstant {

        /**
         * 获取短信验证码的接口
         */
        public static final String MESSAGE_CODE = "/visit/user_getverificationcode.do";


        /**
         * 登陆接口
         */
        public static final String LOGIN_LOFIN = "/visit/user_login.do";

        /**
         * 验证手机验证码的接口
         */
        public static final String MESSAGE_CODE_VERIFY = "/visit/user_checkVerificationCode.do";

        /**
         * 注册会员名和密码的接口
         */
        public static final String MEMBER_NAME_PASSWORD = "/visit/user_register.do";

        /**
         * 重置密码的接口
         */
        public static final String FIX_MEMBER_NAME_PASSWORD = "/visit/setUserLoginPassword.do";

        /**
         * 登陆首页接口
         */
        public static final String LOGIN_MAIN_FRAGMENT = "/visit/loginHomePage.do";

        /**
         * 未登陆首页接口
         */
        public static final String NOT_LOGIN_MAIN_FRAGMENT = "/visit/noLoginHomePage.do";

        /**
         * 评论接口
         */
        public static final String VIDEO_VIEW_PLAY_ADAPTER_COMMENT = "/visit/commentAd.do";

        /**
         * 广告详情页
         */
        public static final String VIDEO_VIEW_PLAY_ADAPTER_DETAIL = "/visit/getAdDetailInfo.do";

        /**
         * 播放广告接口
         */
        public static final String VIDEO_VIEW_PLAY_ADVERTISE = "/visit/playAd.do";

        /**
         * 视频播放也没赞接口
         */
        public static final String VIDEO_VIEW_PLAY_PRAISE = "/visit/praiseAd.do";

        /**
         * 视频分享接口
         */
        public static final String VIDEO_VIEW_PLAY_SHARE = "/visit/shareAd.do";

        /**
         * 视频下载接口
         */
        public static final String VIDEO_VIEW_PLAY_DOWN = "/visit/downloadAd.do";

        /**
         * 收藏接口
         */
        public static final String VIDEO_VIEW_PLAY_COLLECT = "/visit/collectionAd.do";

        /**
         * 踩接口
         */
        public static final String VIDEO_VIEW_PLAY_STEP = "/visit/stepAd.do";

        /**
         * 发表评论的接口
         */
        public static final String VIDEO_VIEW_PLAY_PIBLISH_COMMOT = "/visit/commentAd.do";

        /**
         * 查找接口
         */
        public static final String MAIN_ACTIVITY_SEARCH = "/visit/searchAd.do";

        /**
         * 完成广告的接口
         */
        public static final String VIDEO_VIEW_COMPLETE = "/visit/finishAd.do";

        /**
         * 我的收藏接口
         */
        public static final String VIDEO_VIEW_MY_COLLECT = "/visit/getCollectionAd.do";

        /**
         * 推荐广告接口
         */
        public static final String VIDEO_VIEW_MARKET_ADVERT = "/visit/getRecommendAd.do";

        /**
         * 为完成广告接口
         */
        public static final String VIDEO_VIEW_NOT_COMPELETE = "/visit/unFinishedAd.do";

        /**
         * 向服务器提交数据修改手机号码
         */
        public static final String PHONEBINDINGFIX_COMMIT = "/visit/setPhone.do";
        /**
         * 我的收藏接口
         */
        public static final String COLLECTION_ADVERT = "/visit/getCollectionAd.do";

        /**
         * 开始播放视频的时候的接口
         */
        public static final String VIDEO_VIEW_START_PLAY = "/visit/playAd.do";

        /**
         * 手机拍照以后头像上传接口
         */
        public static final String CENTER_ACTIVITY_PUT_PHOTO = "/visit/changeHead.do";


        /**
         * 删除广告的接口
         */
        public static final String ADVERTIS_COLLECTION_DELETE = "/visit/deletecollectionAd.do";

        public static final String FIX_PAY_PASSWORD = "/visit/changePayPassword.do";
    }

    public class APPlacationAcer {

        /**
         * 用户登陆的手机号码
         */
        public static final String MOBLE_PHONE_NUMBER = "moble_phone_number";

        /**
         * 用户登陆的id
         */
        public static final String LOGIN_USER_ID = "login_user_id";

        /**
         * 用户的名字
         */
        public static final String LOGIN_USER_NAME = "login_user_name";
        /**
         * 用户的头像地址
         */
        public static final String LOGIN_USER_IMAGE = "login_user_image";

        /**
         * 手势密码1.代表开2代表关，末日是开的。
         */
        public static final String LOGIN_USER_GESTURE = "login_user_gesture";


        /**
         * 师傅在登陆也没进入忘记密码的，1默认是在登陆页面进去，2在在安全中心进去的。
         */
        public static final String LOGIN_USER_FIRST_LOGN = "login_user_first_logn";

        /*
        * 记录上次加载刷新的事件*/
        public static final String CLASS_COURSE_TIME = "class_course_time";

        /**
         * 记录下载状态。
         */
        public static final String BUFFER_VIDEO_STATUE = "buffer_video_statue";

        /**
         * 记录是不是播放完成向服务器提交数据。
         */
        public static final String VIDEO_COMPLETE_COMMIT = "video_complete_commit";

        /**
         * 第一次启动页面。
         */
        public static final String FIRST_LOGIN_IMAGEVIEW = "first_login_imageview";

        /**
         * 视频播放页面当前是横屏还是竖屏。
         */
        public static final String VIDEO_VIEW_OPRIATION = "video_view_opriation";


        /**
         * 视频播放页面每两次直接发送的时间间隔。
         */
        public static final String VIDEO_VIEW_LONG_TIME = "video_view_long_time";
    }

//    adb shell monkey -p com.jifenguanggao.weijifen -s 500 --ignore-crashes --ignore-timeouts --monitor-native-crashes -v 10000 > E:\java_monkey_log.t
}
