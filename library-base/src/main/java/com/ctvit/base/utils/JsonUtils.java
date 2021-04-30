package com.ctvit.base.utils;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/12/24.
 */

public final class JsonUtils {

    /**
     * 实体转换成json字符串的方法
     *
     * @param entity 要转的实体
     */
    public static String beanToJson(Object entity) {
        return new Gson().toJson(entity);
    }

    /**
     * json字符串转换成实体的方法
     *
     * @param clz 要转成的类
     */
    public static <T> T jsonToBean(String json, Class<T> clz) {
        return new Gson().fromJson(json, clz);
    }
}
