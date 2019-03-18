package com.cangjie.basetool.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * author：CangJie on 2016/9/28 14:11
 * email：cangjie2016@gmail.com
 */
public class SpUtils {
    private static SharedPreferences sp;
    private final static String CACHE_FILE_NAME = "sp_cache";

    private static void initSp(Context mContext, String fileName) {

        sp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }
    public static void setCache(Context mContext, String key, String value){
        if(sp == null){
            initSp(mContext,CACHE_FILE_NAME);
        }
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }
    public static String getCache(Context mContext, String key){
        if(sp == null){
            initSp(mContext, CACHE_FILE_NAME);
        }
        return sp.getString(key,null);
    }
}
