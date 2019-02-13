package com.mkr.daggerdemo.dependencyinjection.application;

import android.content.Context;

import com.mkr.daggerdemo.utils.NetworkUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    NetworkUtils provideNetworkUtils() {
        return new NetworkUtils();
    }
}
