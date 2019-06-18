package com.dlctt.daggerlearning.di;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule
{
    @Singleton
    @Provides
    public static Picasso providePicasso()
    {
        return Picasso.get();
    }
}
