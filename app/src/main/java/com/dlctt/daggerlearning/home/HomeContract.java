package com.dlctt.daggerlearning.home;

import com.dlctt.daggerlearning.BasePresenter;
import com.dlctt.daggerlearning.BaseView;
import com.dlctt.daggerlearning.model.pojo.User;

public interface HomeContract
{
    interface View extends BaseView
    {
        void onUserInfoLoaded(User user);
    }

    interface Presenter extends BasePresenter
    {
        void loadUserInfo(Integer userId);
    }

}
