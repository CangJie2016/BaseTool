package com.zxw.wuxidriver.ui;

import android.os.Bundle;

import com.cangjie.basetool.mvp.base.PresenterActivity;
import com.zxw.wuxidriver.R;
import com.zxw.wuxidriver.presenter.WelcomePresenter;
import com.zxw.wuxidriver.presenter.view.WelcomeView;

public class WelcomeActivity extends PresenterActivity<WelcomePresenter> implements WelcomeView {
    @Override
    protected WelcomePresenter createPresenter() {
        return new WelcomePresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
}
