package com.dlctt.daggerlearning.profile;

import com.dlctt.daggerlearning.BasePresenter;
import com.dlctt.daggerlearning.BaseView;
import com.dlctt.daggerlearning.model.pojo.User;

public interface ProfileContract
{
    interface View extends BaseView
    {
        void onProfileLoaded(User user);
    }

    interface Presenter extends BasePresenter
    {
        void loadUserProfile(Integer userId);
    }

}
