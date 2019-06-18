package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule
{
    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();
}
