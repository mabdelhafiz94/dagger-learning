package com.dlctt.daggerlearning.login;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.remote.LoginApi;
import com.dlctt.daggerlearning.model.remote.LoginRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class LoginModule
{
    @Provides
    @ActivityScoped
    static LoginContract.Presenter provideLoginPresenter(LoginContract.View view, LoginRepository loginRepository)
    {
        return new LoginPresenter(view, loginRepository);
    }

    @Provides
    @ActivityScoped
    static LoginRepository provideLoginRepository(LoginApi loginApi)
    {
        return new LoginRepository(loginApi);
    }

    @Provides
    @ActivityScoped
    static LoginApi provideLoginApi(Retrofit retrofit)
    {
        return retrofit.create(LoginApi.class);
    }

    @Binds
    @ActivityScoped
    public abstract LoginContract.View bindLoginView(LoginActivity loginActivity);
}
