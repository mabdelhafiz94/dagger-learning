package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.login.LoginActivity;
import com.dlctt.daggerlearning.login.LoginPresenter;
import com.dlctt.daggerlearning.model.remote.LoginApi;
import com.dlctt.daggerlearning.model.remote.LoginRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class LoginModule
{
    @Provides
    @ActivityScoped
    public static LoginPresenter provideLoginPresenter(LoginActivity loginActivity, LoginRepository loginRepository)
    {
        return new LoginPresenter(loginActivity, loginRepository);
    }

    @Provides
    @ActivityScoped
    public static LoginActivity provideLoginActivity(LoginActivity loginActivity)
    {
        return loginActivity;
    }

    @Provides
    @ActivityScoped
    public static LoginRepository provideLoginRepository(LoginApi loginApi)
    {
        return new LoginRepository(loginApi);
    }

    @Provides
    @ActivityScoped
    public static LoginApi provideLoginApi(Retrofit retrofit)
    {
        return retrofit.create(LoginApi.class);
    }
}
