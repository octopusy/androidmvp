package com.module.mvp.presenter.impl;

import android.text.TextUtils;

import com.module.mvp.model.PersonModel;
import com.module.mvp.presenter.LoginPresenter;
import com.module.mvp.presenter.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override public void validateCredentials(PersonModel personModel) {
        if (loginView != null) {
            loginView.showProgress();
        }
        if(null == personModel) {
            loginView.onLoginError("登录失败");
            loginView.hideProgress();
            return;
        }
        if (TextUtils.isEmpty(personModel.getUsername()) ||
                TextUtils.isEmpty(personModel.getPassword())){
            loginView.onLoginError("用户名或密码为空");
            loginView.hideProgress();
            return;
        }
        if (!personModel.getUsername().equals("11") ||
                !personModel.getPassword().equals("11")){
            loginView.onLoginError("用户名或密码错误");
            loginView.hideProgress();
            return;
        }
        loginView.onLoginSuccess();
    }

    @Override public void onDestroy() {
        loginView = null;
    }
}
