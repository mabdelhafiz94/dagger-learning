package com.dlctt.daggerlearning.model.remote;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

@ActivityScoped
public interface LoginApi
{
    @GET("users")
    Observable<List<User>> getAllUsers();
}
