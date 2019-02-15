package com.mkr.daggerdemo.tasks;

import android.util.Log;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.networking.GitHubAPI;
import com.mkr.daggerdemo.networking.models.SearchReposResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchGitHubRepositoriesTask extends BaseTask {

    private GitHubAPI mGitHubAPI;

    public SearchGitHubRepositoriesTask(GitHubAPI gitHubAPI) {
        mGitHubAPI = gitHubAPI;
    }

    /**
     * search repositories
     * @param request request for this call
     * @param callback callback to send the retrofit response
     */
    public void searchRepositories(RequestValues request,
                                   BaseTask.ResponseCallback<SearchGitHubRepositoriesTask.ResponseValues> callback) {

        Call<SearchReposResponse> searchCall = mGitHubAPI.searchForRepository(request.getSearchQuery());
        searchCall.enqueue(new Callback<SearchReposResponse>() {
            @Override
            public void onResponse(Call<SearchReposResponse> call, Response<SearchReposResponse> response) {

                final SearchReposResponse searchResponse = response.body();
                callback.onSuccess(new SearchGitHubRepositoriesTask.ResponseValues(searchResponse));
            }

            @Override
            public void onFailure(Call<SearchReposResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static final class RequestValues implements BaseTask.RequestValues {

        private final String mSearchQuery;

        public RequestValues(String searchQuery) {
            mSearchQuery = searchQuery;
        }

        public String getSearchQuery() {
            return mSearchQuery;
        }
    }

    public static final class ResponseValues implements BaseTask.ResponseValues {

        SearchReposResponse mSearchReposResponse;

        public ResponseValues(SearchReposResponse searchReposResponse) {
            mSearchReposResponse = searchReposResponse;
        }

        public SearchReposResponse getReposResponse() {
            return mSearchReposResponse;
        }
    }
}
