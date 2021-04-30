package com.ctvit.base.net;


import com.ctvit.base.utils.RetrofitClient;

/**
 * 接口地址在这里配置
 */
public final class URL {

    /**
     * 固定参数值
     */
    public static final class PARAM {

        public static final String HOME = "INDEX";  //首页要闻
        public static final String NAV = "NAV";     //下导航
        public static final String HOUR = "HOUR";   //7x24小时
        public static final String LIVE = "LIVE";   //直播导航

    }

    /**
     * 卡片组 - 正常的数据（也是推荐置顶的数据）
     */
    public static final String APP_UPDATE = "https://vod.cctv.cn/apk/cctvapp/updateVersion-caijing.json";
    /**
     * APP更新
     */
    public static final String TEST = "financemobileinf/rest/cctv/cardgroups";

    /**
     * 防盗链
     */
    public static final String BASE_URL_ENCRYPTING = "https://vdn.cctv.cn/cctvmobileinf/rest/cctv/";

    /**
     * CMS系统
     */
    public static final class CMS {

        public static final String BASE = RetrofitClient.BASE_URL_CMS;

        /**
         * 闪屏
         */
        public static final String SPLASH = BASE + "financemobileinf/rest/cctv/splash/update";

        /**
         * 服务器时间
         */
        public static final String SERVER_TIME_URL = BASE + "financemobileinf/rest/cctv/epg/time";


    }

    /**
     * 互动
     */
    public static final class Interaction {

        //线上地址
        public static final String BASE_USER = RetrofitClient.BASE_URL_CMS + "cctv2/";

        /**
         * 首页获取315投诉列表
         */
        public static final String  COMPLAINT = BASE_USER + "complaintApi.php/Complaint/getComplaintList";

        /**
         * 获取用户信息
         */
        public static final String GET_INFO = "userApi.php/User/userGetInfo";

        /**
         * 退出登录
         */
        public static final String EDIT_USER_URL = "userApi.php/user/userExit";

        /**
         * 用户更新access_token接口
         */
        public static final String  CHANGE_ACCESS_TOKEN_URL= "userApi.php/User/userRefreshToken";

    }


    /**
     * Html页面
     */
    public static final class H5 {

        private static final String BASE = RetrofitClient.BASE_URL_CMS;

        public static final String HELP = BASE + "detail/help.html";   //使用帮助

        public static final String PROTOCOL_CLIENT = BASE + "detail/appAgree.html";   //客户端协议

    }

    /**
     * 广告返回字段
     */
    public static class AD {

    }

}
