package com.dlctt.daggerlearning.model.remote;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;

import javax.inject.Inject;

import io.reactivex.Observable;

@ActivityScoped
public class UsersRepository
{
    private UsersApi usersApi;

    @Inject
    public UsersRepository(UsersApi usersApi)
    {
        this.usersApi = usersApi;
    }

    public Observable<User> getUserProfile(int userId)
    {
        return usersApi.getUserById(userId);
    }
}
