package com.mkr.daggerdemo.ui.searchrepos;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.networking.models.RepoDetails;
import com.mkr.daggerdemo.tasks.SearchGitHubRepositoriesTask;
import com.mkr.daggerdemo.ui.BaseActivity;
import com.mkr.daggerdemo.ui.CustomDialogs;
import com.mkr.daggerdemo.ui.adapters.GitHubReposRecyclerAdapter;
import com.mkr.daggerdemo.ui.repodetails.RepoDetailsActivity;
import com.mkr.daggerdemo.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * activity where user can search for the repos. The results are showed in a list.
 * When clicked on a list, will redirect to reperate activity with details
 */
public class SearchGitHubReposActivity extends BaseActivity implements
        SearchGitHubReposContract.View,
        GitHubReposRecyclerAdapter.OnRepoClickedListener {

    private SearchGitHubReposContract.Presenter mPresenter;
    private GitHubReposRecyclerAdapter mReposRecyclerAdapter;

    @BindView(R.id.search_editText)
    EditText mSearchEditText;

    @BindView(R.id.search_results_recyclerView)
    RecyclerView mRecyclerView;

    @Inject
    SearchGitHubRepositoriesTask mSearchReposTask;

    @Inject
    CustomDialogs mCustomDialogs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_git_hub_repos);

        //bind to butterknife
        ButterKnife.bind(this);

        getApplicationComponent().inject(this);

        //initialize presenter
        new SearchGitHubReposPresenter(getResources(),
                this, mSearchReposTask);

        initializeUI();
    }

    private void initializeUI() {

        mReposRecyclerAdapter = new GitHubReposRecyclerAdapter();
        mReposRecyclerAdapter.setOnRepoClickedListener(this);

        mRecyclerView.setAdapter(mReposRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.search_button)
    public void onClickedSearchButton(View view) {
        mPresenter.searchRepos(mSearchEditText.getText().toString());
    }

    @Override
    public void setPresenter(SearchGitHubReposContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void displayRepos(List<RepoDetails> repoDetailsList) {
        mReposRecyclerAdapter.setReposToDisplay(repoDetailsList);
    }

    @Override
    public void showLoader(String message) {
        super.showLoader(message);
    }

    @Override
    public void dismissLoader() {
        super.dismissLoader();
    }

    @Override
    public void showAlert(String title, String message) {
        mCustomDialogs.showSimpleAlertDialog(this, title, message);
    }

    @Override
    public void onClickedRepo(RepoDetails clickedRepo) {

        Bundle b = new Bundle();
        b.putString(Constants.KEY_NAME, clickedRepo.getName());
        b.putString(Constants.KEY_FULL_NAME, clickedRepo.getFullName());
        b.putString(Constants.KEY_DESCRIPTION, clickedRepo.getDescription());
        b.putString(Constants.KEY_URL, clickedRepo.getUrl());
        b.putString(Constants.KEY_AVATAR_URL, clickedRepo.getOwner().getAvatarURL());

        RepoDetailsActivity.open(this, b);
    }
}
