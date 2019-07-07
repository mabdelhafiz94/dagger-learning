package com.dlctt.daggerlearning.home;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.remote.UsersApi;
import com.dlctt.daggerlearning.model.remote.UsersRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class HomeModule
{
    @Provides
    @ActivityScoped
    static HomeContract.Presenter provideHomePresenter(HomeContract.View view, UsersRepository usersRepository)
    {
        return new HomePresenter(view, usersRepository);
    }

    @Provides
    @ActivityScoped
    static UsersRepository providesUsersRepository(UsersApi usersApi)
    {
        return new UsersRepository(usersApi);
    }

    @Provides
    @ActivityScoped
    static UsersApi provideUsersApi(Retrofit retrofit)
    {
        return retrofit.create(UsersApi.class);
    }

    @Binds
    @ActivityScoped
    public abstract HomeContract.View bindHomeView(HomeActivity homeActivity);
}
