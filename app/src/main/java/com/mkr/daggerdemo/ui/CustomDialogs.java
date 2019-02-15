package com.mkr.daggerdemo.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class CustomDialogs {

    public void showSimpleAlertDialog(Context context, String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }
}
