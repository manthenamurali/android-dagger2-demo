package com.mkr.daggerdemo.networking.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchReposResponse {

    @SerializedName("total_count")
    int totalCount;

    @SerializedName("items")
    List<RepoDetails> repoDetailsList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<RepoDetails> getRepoDetailsList() {
        return repoDetailsList;
    }

    public void setRepoDetailsList(List<RepoDetails> repoDetailsList) {
        this.repoDetailsList = repoDetailsList;
    }
}
