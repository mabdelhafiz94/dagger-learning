package com.dlctt.daggerlearning.di;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule
{
    @Provides
    public static Picasso providePicasso()
    {
        return Picasso.get();
    }
}
