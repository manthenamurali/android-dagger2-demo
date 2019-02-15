package com.mkr.daggerdemo.tasks;

public abstract class BaseTask {

    public interface RequestValues {

    }

    public interface ResponseValues {

    }

    public interface ResponseCallback<R> {

        void onSuccess(R response);

        void onFailure(String message);
    }
}
