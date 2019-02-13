package com.mkr.daggerdemo.dependencyinjection.application;

import com.mkr.daggerdemo.Constants;
import com.mkr.daggerdemo.networking.GitHubAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RESTClientModule {

    @Singleton
    @Provides
    Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Note : Dagger will take care of wiring the provides argument (in this case "retrofit"
     * object).
     *
     * @param retrofit retrofit object
     * @return github api interface
     */
    @Singleton
    @Provides
    GitHubAPI getGitHubAPI(Retrofit retrofit) {
        return retrofit.create(GitHubAPI.class);
    }
}
