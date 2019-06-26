package com.dlctt.daggerlearning.di;

import android.app.Application;

import com.dlctt.daggerlearning.DaggerLearningApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuildersModule.class, AppModule.class, RetrofitModule.class})
public interface AppComponent extends AndroidInjector<DaggerLearningApp>
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
