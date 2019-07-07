package com.dlctt.daggerlearning.model.remote;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@ActivityScoped
public interface UsersApi
{
    @GET("users/{userId}")
    Observable<User> getUserById(@Path("userId") Integer userId);
}
