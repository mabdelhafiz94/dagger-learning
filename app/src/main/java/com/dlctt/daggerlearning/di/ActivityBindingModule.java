package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.login.LoginActivity;
import com.dlctt.daggerlearning.login.LoginModule;
import com.dlctt.daggerlearning.profile.ProfileActivity;
import com.dlctt.daggerlearning.profile.ProfileModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule
{
    @ContributesAndroidInjector(modules = {LoginModule.class})
    @ActivityScoped
    abstract LoginActivity bindsLoginActivity();

    @ContributesAndroidInjector(modules = {ProfileModule.class})
    @ActivityScoped
    abstract ProfileActivity bindsProfileActivity();
}
