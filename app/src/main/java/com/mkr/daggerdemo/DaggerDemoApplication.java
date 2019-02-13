package com.mkr.daggerdemo;

import android.app.Application;

import com.mkr.daggerdemo.dependencyinjection.application.ApplicationComponent;
import com.mkr.daggerdemo.dependencyinjection.application.ApplicationModule;
import com.mkr.daggerdemo.dependencyinjection.application.DaggerApplicationComponent;
import com.mkr.daggerdemo.dependencyinjection.application.PresentationModule;
import com.mkr.daggerdemo.dependencyinjection.application.RESTClientModule;

public class DaggerDemoApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .rESTClientModule(new RESTClientModule())
                .presentationModule(new PresentationModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
