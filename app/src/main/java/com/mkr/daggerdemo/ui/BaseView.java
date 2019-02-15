package com.mkr.daggerdemo.ui;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);
}
