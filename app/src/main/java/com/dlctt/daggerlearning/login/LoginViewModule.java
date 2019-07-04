package com.dlctt.daggerlearning.login;

import com.dlctt.daggerlearning.login.LoginActivity;
import com.dlctt.daggerlearning.login.LoginContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginViewModule
{
    @Binds
    abstract LoginContract.View provideLoginView(LoginActivity loginActivity);
}
