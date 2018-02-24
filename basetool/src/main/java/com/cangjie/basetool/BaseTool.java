package com.cangjie.basetool;

import android.content.Context;

/**
 * Created by 李振强 on 2018/2/6.
 */

public class BaseTool {
    public static Context mContext = null;
    public static void init(Context context){
        mContext = context;
    }
}
