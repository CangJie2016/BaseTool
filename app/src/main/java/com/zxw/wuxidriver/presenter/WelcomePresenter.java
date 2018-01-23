package com.zxw.wuxidriver.presenter;

import com.cangjie.basetool.mvp.BasePresenter;
import com.zxw.wuxidriver.presenter.view.WelcomeView;

public class WelcomePresenter extends BasePresenter<WelcomeView> {
    public WelcomePresenter(WelcomeView mvpView) {
        super(mvpView, null);
    }
}
