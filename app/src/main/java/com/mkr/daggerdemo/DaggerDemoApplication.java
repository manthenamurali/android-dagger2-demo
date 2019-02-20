package com.mkr.daggerdemo;

import android.app.Application;

import com.mkr.daggerdemo.dependencyinjection.application.ApplicationComponent;
import com.mkr.daggerdemo.dependencyinjection.application.ApplicationModule;
import com.mkr.daggerdemo.dependencyinjection.application.DaggerApplicationComponent;
import com.mkr.daggerdemo.dependencyinjection.application.PresentationModule;
import com.mkr.daggerdemo.dependencyinjection.networking.DaggerNetworkingComponent;
import com.mkr.daggerdemo.dependencyinjection.networking.NetworkingComponent;
import com.mkr.daggerdemo.dependencyinjection.networking.RESTClientModule;

public class DaggerDemoApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    private NetworkingComponent mNetworkingComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkingComponent = DaggerNetworkingComponent.builder()
                .rESTClientModule(new RESTClientModule())
                .build();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .presentationModule(new PresentationModule())
                .networkingComponent(getNetworkingComponent())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    private NetworkingComponent getNetworkingComponent() {
        return mNetworkingComponent;
    }
}
