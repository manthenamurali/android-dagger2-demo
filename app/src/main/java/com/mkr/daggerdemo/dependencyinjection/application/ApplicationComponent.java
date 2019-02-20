package com.mkr.daggerdemo.dependencyinjection.application;

import com.mkr.daggerdemo.dependencyinjection.networking.NetworkingComponent;
import com.mkr.daggerdemo.dependencyinjection.networking.NetworkingComponentScope;
import com.mkr.daggerdemo.dependencyinjection.networking.RESTClientModule;
import com.mkr.daggerdemo.ui.repodetails.RepoDetailsActivity;
import com.mkr.daggerdemo.ui.searchrepos.SearchGitHubReposActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Refer the below link why this custom scope is used,
 * https://stackoverflow.com/questions/42387631/singleton-component-cannot-depend-on-scoped-components
 *
 * Scopes are little bit confusing during using subcomponents and component dependencies.
 */
@NetworkingComponentScope
@Component(dependencies = NetworkingComponent.class,
           modules = { ApplicationModule.class,
                       PresentationModule.class
                     })
public interface ApplicationComponent {

    void inject(SearchGitHubReposActivity searchGitHubReposActivity);

    void inject(RepoDetailsActivity repoDetailsActivity);
}
