package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.home.HomeActivity;
import com.dlctt.daggerlearning.home.HomeModule;
import com.dlctt.daggerlearning.login.LoginActivity;
import com.dlctt.daggerlearning.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule
{
    @ContributesAndroidInjector(modules = {LoginModule.class})
    @ActivityScoped
    abstract LoginActivity bindsLoginActivity();

    @ContributesAndroidInjector(modules = {HomeModule.class})
    @ActivityScoped
    abstract HomeActivity bindsHomeActivity();
}
