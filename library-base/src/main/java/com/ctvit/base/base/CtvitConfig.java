package com.ctvit.base.base;

import android.app.Application;

import com.ctvit.CtvitUtils;

import com.ctvit.base.Constant;
import com.ctvit.network.C;
import com.ctvit.network.CtvitHttp;
import com.ctvit.network.model.HttpHeaders;
import com.ctvit.network.model.HttpParams;
import com.ctvit.network.utils.CtvitHttpHeaders;
import com.ctvit.network.utils.CtvitHttpParams;
import com.ctvit.qq.CtvitQQ;

import com.ctvit.usercenter.Constants;
import com.ctvit.usercenter.CtvitUserCenter;
import com.ctvit.usercenter.UserCenterAPI;
import com.ctvit.usercenter.entity.UserCenterEntity;
import com.ctvit.usercenter.listener.OnAgainLoginListener;
import com.ctvit.wechat.CtvitWeChat;
import com.ctvit.base.BuildConfig;
import com.ctvit.base.R;
import com.ctvit.base.net.URL;
import com.ctvit.base.utils.AppUtils;

import me.goldze.mvvmhabit.utils.ToastUtils;




/**
 * 这个类处理自己库的配置和初始化，像其它第三方的库，最好每个都建一个这样的类
 */
public class CtvitConfig {

    private volatile static CtvitConfig singleton = null;
    private Application context;

    public CtvitConfig() {

    }

    public static CtvitConfig getInstance() {
        if (singleton == null) {
            synchronized (CtvitConfig.class) {
                if (singleton == null) {
                    singleton = new CtvitConfig();
                }
            }
        }
        return singleton;
    }

    /**
     * 配置Ctvit仓库
     */
    public void init(Application app) {
        this.context = app;
        initBase();
        initDlna();
        initCtvitHttp();
        initToast();


        initTencent();
        initSina();
        initUserCenter();
    }

    /**
     * 配置Toast
     */
    private void initToast() {
//        CtvitToast.init(context);
    }

    /**
     * 配置投屏
     */
    private void initDlna() {
        //CtvitDlna.getInstance().bindService(context, true);
//        CtvitDlna.init(context);
    }


    /**
     * 基础配置（也会对其它库产生作用）
     */
    private void initBase() {
        CtvitUtils.init(context);
        CtvitUtils.getInstance().debug(BuildConfig.DEBUG, null);
    }

    /**
     * 配置全局网络请求
     */
    private void initCtvitHttp() {
        CtvitHttp.init(context);

        //公共参数
        HttpParams commonParams = CtvitHttpParams.getInstance().ap(C.Ap.AP_PHONE).params();
        //公共headers  http://123.56.2.234/cctv2/userApi.php/user/userSmscode
//        HttpHeaders commonHeaders = CtvitHttpHeaders.getInstance().userAgent(C.UserAgent.UA_CHILDREN).headers();
        HttpHeaders commonHeaders = CtvitHttpHeaders.getInstance().userAgent("cctv_app_phone_cctv2").headers();
        //网络请求统一配置
        CtvitHttp.getInstance()
                .setRetryCount(0)
                .setCacheVersion(AppUtils.getAppVersionCode()) //随着版本变化，用app的versioncode就可以了
                .addCommonHeaders(commonHeaders)
                .addCommonParams(commonParams);

        //oauth库必须依赖网络库，所以上面的公共参数对oauth也是有作用的
        //配置Oauth 1.0信息
//        OAuthConfigEntity10 oAuthConfigEntity10 = new OAuthConfigEntity10();
//        oAuthConfigEntity10.setConsumerKey("e89cda1803acf8c6165a3e58b13854d505c63d029"); //在互动后台注册获得
//        oAuthConfigEntity10.setConsumerSecret("66e0fa54c95930bd0e9bddfb6da4a929"); //在互动后台注册获得
//        oAuthConfigEntity10.setRequestTokenURL(URL.Interaction.BASE_USER + "authApi.php/oauth/requestToken"); //获取非鉴权Token的接口地址
//        oAuthConfigEntity10.setAccessTokenURL(URL.Interaction.BASE_USER + "authApi.php/oauth/accessToken"); //获取鉴权Token的接口地址
//        CtvitOAuth.getInstance().addCommonOAuth10Params(oAuthConfigEntity10);
    }


    /**
     * 用户中心
     */
    private void initUserCenter() {
        UserCenterEntity initEntity = new UserCenterEntity();
        initEntity.setClientId(Constant.CLIENT_ID);
        //参考互动接口文档，多个用“,”分隔
        //组件内置了默认权限：uc
//        initEntity.setImplicitScope("");
        //组件内置了默认权限：uc,openid,offline_access
//        initEntity.setCodeScope("");
//        initEntity.setRedirectUri("http://192.168.168.73:8088/uc_api_c/v1/callback?client_id=" + initEntity.getClientId());
        initEntity.setPublicKey(Constant.PUBLIC_KEY);
        initEntity.setRefreshTokenUrl(URL.Interaction.BASE_USER + URL.Interaction.CHANGE_ACCESS_TOKEN_URL); //互动平台的续期accessToken的接口地址，为空则为用户中心的token续期接口
        initEntity.setSecretKey(Constant.SECRET_KEY);


        if (!Constant.PRODUCTION) {
            //配置接口环境，组件内置的是正式环境 , 正式时需要注释掉代码
            String base = "https://uctest.cctv.cn/uc_api_c/v1";
            UserCenterAPI.AUTHORIZE_IMPLICIT = base + "/authorize";
            UserCenterAPI.AUTHORIZE_CODE = base + "/authorize";
            UserCenterAPI.REFURBISH_TOKEN = base + "/refresher";
            UserCenterAPI.DELETE_TOKEN = base + "/token";
            UserCenterAPI.USERINFO_WECHAT = base + "/wechat";
            UserCenterAPI.SMS_CODE = base + "/smscode";
            UserCenterAPI.REGISTER_PHONE = base + "/user";
            UserCenterAPI.UPDATE_PASSWORD = base + "/user";
            UserCenterAPI.FORGET_PASSWORD = base + "/user";
            UserCenterAPI.GET_USERINFO = base + "/userinfo";
            UserCenterAPI.GET_WECHAT_USERINFO = base + "/wechat";
            UserCenterAPI.GET_QQ_USERINFO = base + "/qqchat";
            UserCenterAPI.GET_SINA_WEIBO_USERINFO = base + "/wbchat";
        }


        CtvitUserCenter.init(context, initEntity);
        CtvitUserCenter.getInstance().setOnAgainLoginListener(new OnAgainLoginListener() {
            @Override
            public void onMessage(int code, String message) {
                // 只处理用户注销的逻辑或者跳转登录页面 只有在usertoken失效时执行该方法
                if (code == Constants.Code.AGAIN_LOGIN) {
                    User.reqEdit();
                    //uerToken失效时
                    ToastUtils.showShort(R.string.token_error);
                }
            }
        });

    }

    /**
     * 初始化腾讯相关功能的配置
     */
    private void initTencent() {
        CtvitQQ.init("1105380659", context);//appId 同时需要在app的build.gradle文件配置QQ_APPID
        //f2013006f41ff6a2b90865c8fb51298d
        CtvitWeChat.init("wxf3a24bcbc2810a60", null, context);
    }

    /**
     * 初始化新浪相关功能的配置
     * scope : 通过scope，平台将开放更多的微博核心功能给开发者，同时也加强用户隐私保护，提升了用户体验
     * ，用户在新OAuth2.0授权页中有权利选择赋予应用的功能。
     * 可以为空
     * redirectUrl : 你的回调地址 在微博后台查看和配置
     * <p>
     * appKey : 在使用新浪微博时 请换成自己申请的AppKey
     */
    private void initSina() {
//        AuthInfo authInfo = new AuthInfo(context, "915822878", "https://api.weibo.com/oauth2/default.html", "all");
//        //这个是体育的 经测试 使用体育的AppKey可以成功获取用户信息
//        //想测的话 需要把applicationId换成体育的 签名文件也换成体育的
////        AuthInfo authInfo = new AuthInfo(context, "2226505430", "https://api.weibo.com/oauth2/default.html", "all");
//        CtvitSinaWeibo.init(authInfo, context);
    }

}
