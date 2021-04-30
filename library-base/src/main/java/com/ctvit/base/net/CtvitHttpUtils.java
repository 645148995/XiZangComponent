package com.ctvit.base.net;





import com.alibaba.fastjson.JSON;
import com.ctvit.network.callback.CallBack;
import com.ctvit.network.exception.ApiException;

import com.ctvit.network.request.DownloadRequest;
import com.ctvit.network.request.GetRequest;
import com.ctvit.network.request.PostRequest;
import com.ctvit.network.utils.Utils;
import com.ctvit.usercenter.module.Authentication;
import com.ctvit.usercenter.module.NoAuthentication;




/**
 * Http请求工具类
 */
public final class CtvitHttpUtils {

    /**
     * 发送 下载 请求
     */
    public static <T> void downLoad(DownloadRequest request, final CallBack<T> callBack) {
        request.execute(new HttpCallBack(callBack));
    }

    /**
     * 发送 Get 请求
     */
    public static <T> void get(GetRequest request, final CallBack<T> callBack) {
        request.params(NetHttpUtils.addParamForHD(request.getUrl()));
        request.execute(new HttpCallBack(callBack));
    }

    /**
     * 发送 Post 请求
     */
    public static <T> void post(PostRequest request, final CallBack<T> callBack) {
        request.params(NetHttpUtils.addParamForHD(request.getUrl()));
        request.execute(new HttpCallBack(callBack));
    }

    /**
     * 发送 Oauth 1.0 请求
     */
//    public static <T> void post(OAuthRequest10 request, final CallBack<T> callBack) {
//        request.execute(new HttpCallBack(callBack));
//    }

    /**
     * 鉴权（非OAUTH2.0）HTTP POST
     */
    public static <T> void post(Authentication request, final CallBack<T> callBack){
//        if (!CtvitNetUtils.isNetworkAvailable()){
//            return;
//        }
        request.execute(new HttpCallBack(callBack));
    }

    /**
     * 非鉴权（非OAUTH2.0）HTTP POST
     */
    public static <T> void post(NoAuthentication request, final CallBack<T> callBack){
//        if (!CtvitNetUtils.isNetworkAvailable()){
//            return;
//        }
        request.execute(new HttpCallBack(callBack));
    }

    private static class HttpCallBack<T> extends CallBack<String> {

        private CallBack<T> callBack;

        public HttpCallBack(CallBack<T> callBack) {
            this.callBack = callBack;
        }

        @Override
        public void onStart() {
            callBack.onStart();
        }

        @Override
        public void onCompleted() {
            callBack.onCompleted();
        }

        @Override
        public void onError(ApiException e) {
//            if (e.getCode() == CtvitOAuth.ERROR_CODE) { //令牌失效
//                User.deleteUserInfo();
//                SPUtils.put("SIGN_IN_DATE", "");
//            }
            callBack.onError(e);
        }

        @Override
        public void onSuccess(String data) {
            try {
                Class<T> clazz = Utils.getClass(callBack.getType(), 0);
                if (clazz.equals(String.class)) {
                    callBack.onSuccess((T) data);
                } else {
                    callBack.onSuccess(JSON.parseObject(data, clazz));
                }
            } catch (Exception e) {
                onError(new ApiException(e, ApiException.ERROR.CAST_ERROR));
            }
        }
    }
}
