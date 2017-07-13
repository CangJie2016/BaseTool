package com.cangjie.basetool.mvp.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * author：CangJie on 2016/8/18 16:44
 * email：cangjie2016@gmail.com
 */
public abstract class PresenterActivity<P> extends BaseHeadActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onCreate(savedInstanceState);

    }

    protected abstract P createPresenter();

    protected void getPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS}, 100);
        }
    }
}
