package com.dlctt.daggerlearning.login;

import com.dlctt.daggerlearning.BasePresenter;
import com.dlctt.daggerlearning.BaseView;

public interface LoginContract
{
    interface View extends BaseView
    {
        void onLoginSuccess();

        void onLoginFail();
    }

    interface Presenter extends BasePresenter
    {
        void login(int UserId);
    }

}
