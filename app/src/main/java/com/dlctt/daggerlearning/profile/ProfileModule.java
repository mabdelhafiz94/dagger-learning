package com.dlctt.daggerlearning.profile;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.remote.UsersApi;
import com.dlctt.daggerlearning.model.remote.UsersRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class ProfileModule
{
    @ActivityScoped
    @Provides
    static ProfilePresenter provideProfilePresenter(ProfileContract.View view, UsersRepository usersRepository)
    {
        return new ProfilePresenter(view, usersRepository);
    }

    @ActivityScoped
    @Provides
    static UsersRepository ProvideUsersRepository(UsersApi usersApi)
    {
        return new UsersRepository(usersApi);
    }

    @ActivityScoped
    @Provides
    static UsersApi provideUsersApi(Retrofit retrofit)
    {
        return retrofit.create(UsersApi.class);
    }

    @ActivityScoped
    @Binds
    public abstract ProfileContract.View bindsProfileView(ProfileActivity profileActivity);

}
