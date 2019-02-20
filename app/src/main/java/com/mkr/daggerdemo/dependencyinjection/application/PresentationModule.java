package com.mkr.daggerdemo.dependencyinjection.application;

import com.mkr.daggerdemo.networking.GitHubAPI;
import com.mkr.daggerdemo.tasks.SearchGitHubRepositoriesTask;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    SearchGitHubRepositoriesTask getGitHubSearchTask(GitHubAPI gitHubApi) {
        return new SearchGitHubRepositoriesTask(gitHubApi);
    }
}
