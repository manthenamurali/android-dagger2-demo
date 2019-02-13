package com.mkr.daggerdemo.ui.searchrepos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.tasks.SearchGitHubRepositoriesTask;
import com.mkr.daggerdemo.ui.BaseActivity;
import com.mkr.daggerdemo.utils.NetworkUtils;

import javax.inject.Inject;

public class SearchGitHubReposActivity extends BaseActivity {

    @Inject
    NetworkUtils mNetworkUtils;

    @Inject
    SearchGitHubRepositoriesTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_git_hub_repos);

        getApplicationComponent().inject(this);

        task.getSearchRepositories("android");
    }
}
