package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule
{
    @ContributesAndroidInjector(modules = {LoginModule.class, LoginViewModule.class})
    @ActivityScoped
    abstract LoginActivity bindsLoginActivity();
}
