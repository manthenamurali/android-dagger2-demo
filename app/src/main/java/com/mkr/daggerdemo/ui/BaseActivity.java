package com.mkr.daggerdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mkr.daggerdemo.DaggerDemoApplication;
import com.mkr.daggerdemo.dependencyinjection.application.ApplicationComponent;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((DaggerDemoApplication) getApplication()).getApplicationComponent();
    }
}
