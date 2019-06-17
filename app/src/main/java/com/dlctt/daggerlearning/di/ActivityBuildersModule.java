package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.login.LoginActivity;
import com.dlctt.daggerlearning.models.User;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule
{
    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();

    //    @Singleton
    @Provides
    public static User provideUser()
    {
        return new User(11, "User11");
    }
}
