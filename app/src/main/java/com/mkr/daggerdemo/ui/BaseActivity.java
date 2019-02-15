package com.mkr.daggerdemo.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.mkr.daggerdemo.DaggerDemoApplication;
import com.mkr.daggerdemo.dependencyinjection.application.ApplicationComponent;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((DaggerDemoApplication) getApplication()).getApplicationComponent();
    }

    public void showLoader(String message) {
        mProgressDialog.setMessage(message);
        if(!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    public void dismissLoader() {
        if(mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void dismissKeyboard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context
                .INPUT_METHOD_SERVICE);
        if(imm != null) {
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }
}
