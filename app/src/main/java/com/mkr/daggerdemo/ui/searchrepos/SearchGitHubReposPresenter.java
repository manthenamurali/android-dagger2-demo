package com.mkr.daggerdemo.ui.searchrepos;

import android.content.res.Resources;
import android.util.Log;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.tasks.BaseTask;
import com.mkr.daggerdemo.tasks.SearchGitHubRepositoriesTask;

public class SearchGitHubReposPresenter implements
        SearchGitHubReposContract.Presenter {

    private final Resources mResources;
    private final SearchGitHubReposContract.View mView;
    private final SearchGitHubRepositoriesTask mSearchReposTask;

    SearchGitHubReposPresenter(Resources resources,
                               SearchGitHubReposContract.View view,
                               SearchGitHubRepositoriesTask searchReposTask) {

        mResources = resources;
        mSearchReposTask = searchReposTask;

        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void searchRepos(String repoToSearch) {
        mView.showLoader(mResources.getString(R.string.fetching_repos));
        mSearchReposTask.searchRepositories(new SearchGitHubRepositoriesTask.RequestValues(repoToSearch),
                searchReposResponse);
    }

    /**
     * Response callback for repos search task
     */
    private BaseTask.ResponseCallback<SearchGitHubRepositoriesTask.ResponseValues> searchReposResponse =
            new BaseTask.ResponseCallback<SearchGitHubRepositoriesTask.ResponseValues>() {

        @Override
        public void onSuccess(SearchGitHubRepositoriesTask.ResponseValues response) {
            mView.dismissLoader();

            if(response.getReposResponse().getRepoDetailsList().size() == 0) {
                mView.showAlert(mResources.getString(R.string.alert),
                        mResources.getString(R.string.no_repos_found));
            } else {
                mView.displayRepos(response.getReposResponse().getRepoDetailsList());
            }
        }

        @Override
        public void onFailure(String message) {
            mView.dismissLoader();
            mView.showAlert(mResources.getString(R.string.alert),
                    mResources.getString(R.string.failed_to_get_details));
        }
    };
}
