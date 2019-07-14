package com.dlctt.daggerlearning.login;

import com.dlctt.daggerlearning.BasePresenter;
import com.dlctt.daggerlearning.BaseView;
import com.dlctt.daggerlearning.model.pojo.User;

import java.util.ArrayList;

public interface LoginContract
{
    interface View extends BaseView
    {
        void onLoginSuccess(int userId);

        void onUsersLoaded(ArrayList<User> users);

        void onLoginFail();
    }

    interface Presenter extends BasePresenter
    {
        void login(int UserId);


        void loadUsers();
    }

}
