package com.mkr.daggerdemo.dependencyinjection.networking;

import com.mkr.daggerdemo.networking.GitHubAPI;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Since RESTClientModule uses a singleton annotation for RestClient, we need to define
 * that annotation at component level also.
 *
 * For testing just remove this and see the error, for better understanding.
 */
@Singleton
@Component(modules = RESTClientModule.class)
public interface NetworkingComponent {

    /*
     * Application component needs this below API for a task. So first we make sure that
     * ApplicationComponent depends on NetworkingComponent (refer to "dependencies" in
     * ApplicationComponent).
     *
     * But making dependency (and using @Provides) doesn't mean that automatic wiring will be done.
     * We need to manually expose the @Provides instance which other component will be expecting.
     * Only then the dependency works.
     *
     * To Test comment the below code and observer
     * 1. DaggerDemoApplication class :- While creating the networking component rest module will
     * be deprecated.
     * 2. DaggerNetworkingComponent.class :- You wont see any methods auto generated which
     * return GitHubAPI. So other components cannot use this instance for their creation.
     */
    GitHubAPI getGitHubApi();
}
