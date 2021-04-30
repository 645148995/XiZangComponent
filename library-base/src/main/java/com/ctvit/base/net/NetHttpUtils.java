package com.ctvit.base.net;


import android.content.Context;
import android.text.TextUtils;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;

import com.ctvit.base.Constant;
import com.ctvit.network.model.HttpParams;
import com.ctvit.base.base.User;


/**
 * Created by PC on 2019/5/30.
 */

public class NetHttpUtils {
    /**
     * 判断是否是互动接口
     *
     * @param url
     * @return
     */
    private static boolean isHUDong(String url) {
        if (TextUtils.isEmpty(url))
            return false;
        if (url.startsWith(URL.Interaction.BASE_USER))
            return true;
        return false;
    }

    /**
     * 给互动添加公共参数
     *
     * @param url
     * @return
     */
    public static HttpParams addParamForHD(String url) {
        HttpParams httpParams = new HttpParams();
        if (NetHttpUtils.isHUDong(url)) {
            httpParams.put("app_source", Constant.APP_SOURCE);
            httpParams.put("source", Constant.APP_SOURCE);
            if (!TextUtils.isEmpty(User.getUserInfo(User.UID))) {
                //只有登录状态，才传usertoken
                httpParams.put("usertoken", User.getAccessToken());
            }
        }
        return httpParams;
    }

    /**
     * 根据context获取Lifecycle
     *
     * @param context
     * @return
     */
    public static Lifecycle getLifeCycle(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof FragmentActivity) {
            return ((FragmentActivity) context).getLifecycle();
        }
        return null;
    }
}
