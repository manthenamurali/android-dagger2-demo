package com.mkr.daggerdemo.ui.searchrepos;

import com.mkr.daggerdemo.networking.models.RepoDetails;
import com.mkr.daggerdemo.ui.BasePresenter;
import com.mkr.daggerdemo.ui.BaseView;

import java.util.List;

public interface SearchGitHubReposContract {

    interface View extends BaseView<Presenter> {

        void showLoader(String message);

        void dismissLoader();

        void showAlert(String title, String message);

        void displayRepos(List<RepoDetails> repoDetailsList);
    }

    interface Presenter extends BasePresenter {

        void searchRepos(String repoToSearch);
    }
}
