package com.mkr.daggerdemo.networking;

import com.mkr.daggerdemo.networking.models.SearchReposResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubAPI {

    @GET("/search/repositories")
    Call<SearchReposResponse> searchForRepository(@Query("q") String repoName);
}
