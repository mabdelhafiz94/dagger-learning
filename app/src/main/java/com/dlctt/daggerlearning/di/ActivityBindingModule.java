package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.login.LoginActivity;
import com.dlctt.daggerlearning.login.LoginModule;
import com.dlctt.daggerlearning.login.LoginViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule
{
    @ContributesAndroidInjector(modules = {LoginModule.class, LoginViewModule.class})
    @ActivityScoped
    abstract LoginActivity bindsLoginActivity();
}
