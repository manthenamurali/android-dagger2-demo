package com.mkr.daggerdemo.dependencyinjection.application;

import com.mkr.daggerdemo.tasks.SearchGitHubRepositoriesTask;
import com.mkr.daggerdemo.ui.searchrepos.SearchGitHubReposActivity;

import javax.inject.Singleton;

import dagger.Component;

//since we used @Singleton inside modules, we also need to annotate it for component level
@Singleton
@Component(modules = {ApplicationModule.class, RESTClientModule.class, PresentationModule.class})
public interface ApplicationComponent {

    void inject(SearchGitHubReposActivity searchGitHubReposActivity);
}
