package com.mkr.daggerdemo.ui.repodetails;

import android.os.Bundle;

import com.mkr.daggerdemo.networking.models.RepoDetails;
import com.mkr.daggerdemo.ui.BasePresenter;
import com.mkr.daggerdemo.ui.BaseView;

import java.util.List;

public interface RepoDetailsContract {

    interface View extends BaseView<Presenter> {

        void displayRepoDetails(RepoDetailsPresenter.RepoDetailsToDisplay repoDetails);
    }

    interface Presenter extends BasePresenter {

        /**
         * For now get get the details from bundle. case can be as call from server
         * @param repoDetailsBundle bundle
         */
        void getRepoDetails(Bundle repoDetailsBundle);

        String getRepoUrl();
    }
}
