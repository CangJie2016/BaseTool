package com.cangjie.basetool.mvp;


import android.content.Context;

import com.cangjie.basetool.utils.SpUtils;

/**
 * author：CangJie on 2016/8/18 14:38
 * email：cangjie2016@gmail.com
 */
public class BasePresenter<V extends BaseView> {
    public V mvpView;
    private Context mContext;

    public BasePresenter(V mvpView, Context context) {
        this.mvpView = mvpView;
        this.mContext = context;

    }

    protected String keyCode(){
        return SpUtils.getCache(mContext, SpUtils.KEYCODE);
    }
    protected String userPhone(){
        return SpUtils.getCache(mContext, SpUtils.USER_PHONE);
    }
    protected String userId(){
        return SpUtils.getCache(mContext, SpUtils.USER_ID);
    }
}
