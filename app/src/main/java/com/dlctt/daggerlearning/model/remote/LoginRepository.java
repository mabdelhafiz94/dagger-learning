package com.dlctt.daggerlearning.model.remote;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

@ActivityScoped
public class LoginRepository
{
    private LoginApi loginApi;

    @Inject
    public LoginRepository(LoginApi loginApi)
    {
        this.loginApi = loginApi;
    }

    public Observable<List<User>> login()
    {
        return loginApi.getAllUsers();
    }
}
