package com.mkr.daggerdemo.tasks;

import android.util.Log;

import com.mkr.daggerdemo.networking.GitHubAPI;
import com.mkr.daggerdemo.networking.models.SearchReposResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchGitHubRepositoriesTask {

    private GitHubAPI mGitHubAPI;

    public SearchGitHubRepositoriesTask(GitHubAPI gitHubAPI) {
        mGitHubAPI = gitHubAPI;
    }

    public void getSearchRepositories(String searchQuery) {

        Call<SearchReposResponse> searchCall = mGitHubAPI.searchForRepository(searchQuery);
        searchCall.enqueue(new Callback<SearchReposResponse>() {
            @Override
            public void onResponse(Call<SearchReposResponse> call, Response<SearchReposResponse> response) {

                SearchReposResponse searchResponse = response.body();
                Log.e("mkr", "on response called. " + searchResponse.getTotalCount());
            }

            @Override
            public void onFailure(Call<SearchReposResponse> call, Throwable t) {
                Log.e("mkr", "failed to saerch repos. Reason = " + t.getMessage());
            }
        });
    }
}
