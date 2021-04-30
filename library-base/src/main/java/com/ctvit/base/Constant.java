package com.ctvit.base;

/**
 * 全局常量类
 */
public final class Constant {

    //正式环境2020-02-20  第三方登陆，分享的ID
    public static final String CLIENT_ID = "uc11bd6246ddaeb592";
    public static final String SECRET_KEY = "ucd41b00aa09e472ac26a0fe9e23a432c9";
    public static final String PUBLIC_KEY = "-----BEGIN PUBLIC KEY----- MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6u13S64lZiCXtF0jX1/Ptqc3a FlD2dDMPtPimRZKZxD7KR6U6X92kuMwWtV1iDOD9wKa9r+z5V3kT4tjnzncBgV9W i4+n2VgKaYA2CQ5Bu16HagXs2jJFOk1BSm3DYv9xbff9H1So7R6uS+WKAF0NdzPz uVABRz7ZBSE0SAPzywIDAQAB -----END PUBLIC KEY-----";

    //登陆相关
    public static final boolean PRODUCTION  = true;//正式环境 https://test.cctv.cn/uc_api_c/v1"
//    public static final boolean PRODUCTION = false;//测试环境 https://uctest.cctv.cn/uc_api_c/v1"
    /**
     * LiveDataBus的常量定义
     */
    public static final class LiveDataBus {
        public static final String TABAUTOREFRESH = "TAB_AUTOREFRESH"; // 直播

    }
    /**
     * 分页相关配置
     */
    public static final class Paging {
        /**
         * 每页20条数据
         */
        public static final int PAGE_SIZE = 20;
    }

    // intent extra
    public static final String EXTRA_PAGE_ID = "extra_page_id";


    // sharedPreferences key

    public static final String APP_AGREE_PROTOCOL = "app_agree_protocol";
    public static final String APP_FIRST_INSTALL = "app_first_install";

    /**已选中频道的json*/
    public static final String SELECTED_CHANNEL_JSON = "selectedChannelJson";
    /**w未选频道的json*/
    public static final String UNSELECTED_CHANNEL_JSON = "unselectChannelJson";

    /**频道对应的请求参数*/
    public static final String CHANNEL_CODE = "channelCode";
    public static final String IS_VIDEO_LIST = "isVideoList";


    public static final String DATA_SELECTED = "dataSelected";
    public static final String DATA_UNSELECTED = "dataUnselected";



    public static final class LiveStatus {
        //直播中
        public static final String LIVE_START = "正在直播";

        //已结束
        public static final String LIVE_END = "已结束";

        //未开始
        public static final String LIVE_NOT = "未开始";
    }

    /**
     * 卡片序号（包含了自定义的和接口定义的）
     * 因为有的卡片需要特别判断，直接在程序里写数字不太好，所以在这里配置下
     */
    public static final class CardStyle {
        //轮播图
        public static final int N_256 = 256;
        //大图
        public static final int N_261 = 261;

        //-----------------------------以上是示例，以下是财经--------------------------------
        //轮播图
        public static final int N_3001 = 3001;

        //大视频 - 广告
        public static final int N_3044 = 3044;

        //----------本地自定义类型---------------------------

        //经济之声交通广播
        public static final int N_1001 = 1001;

    }



    /**
     * 卡片组的link 以app开头的
     */
    public static final class LinkApp {
        //专题列表
//        public static final String PAGE = "app://PAGE";

        //图文底层（包含了专题列表app://PAGE）
        public static final String BASE = "app://";

        //图文底层
        public static final String ARTI = "app://ARTI";

        //视频底层
        public static final String VIDE = "app://VIDE";

        //视频集（样式1-播放单显示标题）
        public static final String VIDA = "app://VIDA";

        //视频集（样式2-播放单显示集数）
        public static final String VIDEOALBUM1 = "videoalbum1://";

        //图集
        public static final String PHOA = "app://PHOA";

        //视频直播底层
        public static final String VIDEOLIVE = "videolive://";

        //微信
        public static final String WEIXIN = "weixin://";

        //VR视频
        public static final String VR = "app://VR";

        //VR点播
        public static final String VRDE = "app://VRDE";

        //音频底层
        public static final String MUSIC = "app://AUDI";

        //音频集底层
        public static final String MUSIC_COllECTIONS = "app://AUDA";

        //竖屏直播
        public static final String VERTICAL_LIVE = "verticalvideolive://";

        //竖屏点播
        public static final String VERTICAL_VOD = "verticalapp://";
    }

    /**
     * 从哪个页面跳转进来的
     */
    public static final String FORWARD_SOURCE = "FORWARD_SOURCE";

    /**
     * app来源
     */
    public static final String APP_SOURCE = "14";
    /**
     * 我的设置常量
     */
    public static final class SetC {
        //对应"消息推送"，true为打开，false为关闭
        public static final String NEWS_PUSH = "NEWS_PUSH";
        //对应"仅wifi下自动播放"，true为打开，false为关闭
        public static final String AUTO_PLAY = "AUTO_PLAY";
        //对应“弹幕”，true为打开，false为关闭
        public static final String DANMU_ON = "AUTO_PLAY";
        //对应"下载功能-音频"，true为打开，false为关闭
        public static final String AUTO_DOWNLOAD_AUDIO = "AUTO_DOWNLOAD_AUDIO";
        //对应"下载功能-视频"，true为打开，false为关闭
        public static final String AUTO_DOWNLOAD_VIDEO = "AUTO_DOWNLOAD_VIDEO";
    }
}
