package com.ctvit.base.base;



import android.text.TextUtils;

import com.ctvit.network.callback.SimpleCallBack;
import com.ctvit.network.exception.ApiException;
import com.ctvit.network.request.PostRequest;

import com.ctvit.usercenter.CtvitUserCenter;
import com.ctvit.usercenter.entity.TokenCacheEntity;
import com.ctvit.usercenter.utils.TokenCacheUtils;
import com.ctvit.base.entity.UserInfoEntity;
import com.ctvit.base.net.CtvitHttpUtils;
import com.ctvit.base.net.URL;
import com.ctvit.base.utils.JsonUtils;
import com.ctvit.base.utils.SPUtils;


/**
 * Created by Administrator on 2016/12/24.
 */

public class User {

    public static final String SAVE_USER_KEY = "SAVE_USER_KEY";
    public static final String SAVE_LOGIN_KEY = "SAVE_LOGIN_KEY";

    /**
     * 以下是获取用户信息的KYE
     */
    public static final int UID = 0;
    public static final int LOGINNAME = 1;
    public static final int PASSWORD = 2;
    public static final int PHONE = 3;
    public static final int CREATETEIME = 4;
    public static final int NICKNAME = 5;
    public static final int DEVICEID = 6;
    public static final int INVITECODE = 7;
    public static final int INVITEDCODE = 8;
    public static final int USERLOGO = 9;
    public static final int STATUS = 10;
    public static final int SEX = 11;
    public static final int BIRTHDAY = 12;
    public static final int REGISTRATIONID = 13;
    public static final int USERTOKEN = 14;

    private User() {
    }

    /**
     * 保存用户信息
     *
     * @param entity 要保存的实体
     */
    public static void saveUserInfo(UserInfoEntity entity) {
        if (entity == null) {
            return;
        }
        SPUtils.put(SAVE_USER_KEY, JsonUtils.beanToJson(entity));
    }

    /**
     * 清空用户信息
     */
    public static void deleteUserInfo() {
        SPUtils.remove(SAVE_USER_KEY);
        //SPUtils.remove(SAVE_LOGIN_KEY);
        clearLoginInfo();
        TokenCacheUtils.delete(null);
    }

    public static void reqEdit() {
        TokenCacheEntity tokenCacheEntity = TokenCacheUtils.query();
        if (tokenCacheEntity == null || TextUtils.isEmpty(tokenCacheEntity.getAccessToken())){
            deleteUserInfo();
            return;
        }

        PostRequest postRequest = new PostRequest(URL.Interaction.BASE_USER + URL.Interaction.EDIT_USER_URL);
        CtvitHttpUtils.post(CtvitUserCenter.authentication().postRequest(postRequest), new SimpleCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                deleteUserInfo();
            }

            @Override
            public void onError(ApiException e) {
                super.onError(e);
                deleteUserInfo();
//                if (isSuccess())
//                    return;
            }
        });
//        deleteUserInfo();
    }

    /**
     * 更改用户信息
     */
    public static void updateUserInfo(UserInfoEntity entity) {
        saveUserInfo(entity);
    }

    /**
     * 获取存储在本地的用户信息 返回String类型
     */
    public static String getUserInfo(int which) {

        UserInfoEntity.InfoBean info = null;
        String user = (String) SPUtils.get(SAVE_USER_KEY, "");
        if (TextUtils.isEmpty(user)) {
            return user;
        }
        info = JsonUtils.jsonToBean(user, UserInfoEntity.class).getInfo();

        switch (which) {
            case UID:
                String userId;
                if (!TextUtils.isEmpty(user)) {
                    UserInfoEntity entity = JsonUtils.jsonToBean(user, UserInfoEntity.class);
                    if (entity != null) {
                        if (entity.getInfo() != null) {
                            userId = entity.getInfo().getUid();
                        } else {
                            userId = "";
                        }
                    } else {
                        userId = "";
                    }
                } else {
                    userId = "";
                }
                return userId;
            case LOGINNAME:
                return info.getLoginname();
            case PASSWORD:
//                return info.getPassword();
                return "密码接口未提供字段";
            case PHONE:
                return info.getPhone();
            case CREATETEIME:
                return info.getCreatetime();
            case NICKNAME:
                return info.getNickname();
            case DEVICEID:
                return info.getDeviceid();
            case INVITECODE:
                return info.getInvitcode();
            case INVITEDCODE:
                return info.getInvitedcode();
            case USERLOGO:
                return info.getUserlogo();
            case STATUS:
                return info.getStatus();
            case SEX:
                return info.getSex();
            case BIRTHDAY:
                return info.getBirthday();
            case REGISTRATIONID:
                return info.getRegistrationid();
            case USERTOKEN:
                return info.getUsertoken();
            default:
                return null;
        }
    }

    /**
     * 获取存储在本地的用户信息 返回entity
     * 一般只用在用户中心（我的）页面
     */
    public static UserInfoEntity.InfoBean getUserInfo() {
        String userJson = (String) SPUtils.get(SAVE_USER_KEY, "");
        if (!TextUtils.isEmpty(userJson)) {
            UserInfoEntity userEntity = JsonUtils.jsonToBean(userJson, UserInfoEntity.class);
            return userEntity.getInfo();
        } else {
            return null;
        }
    }

    public static void clearLoginInfo() {
        SPUtils.remove(SAVE_LOGIN_KEY);
//        CtvitUtils.setUserInfo();
    }

    public static String getAccessToken() {
        String usertoken;
        TokenCacheEntity tokenCacheEntity = TokenCacheUtils.query();
        if (tokenCacheEntity != null) {
            usertoken = tokenCacheEntity.getAccessToken();
        } else {
            usertoken = "";
        }

        return usertoken;
    }


    /**
     * token校验接口，请求gettoken要写在这个回调里
     */
    public static void reqUserInfo(final UpDataUserState upDataUserState) {

        PostRequest postRequest = new PostRequest(URL.Interaction.BASE_USER + URL.Interaction.GET_INFO);
        CtvitHttpUtils.post(CtvitUserCenter.authentication().postRequest(postRequest), new SimpleCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                UserInfoEntity entity = JsonUtils.jsonToBean(s, UserInfoEntity.class);
                if (entity.getSucceed().equals("1")) {
                    upDataUserState.onSuccess();
                }
            }
            @Override
            public void onError(ApiException e) {
                super.onError(e);
                upDataUserState.onError();
            }
        });
    }

    public interface UpDataUserState {
        void onSuccess();
        void onError();
    }
}
