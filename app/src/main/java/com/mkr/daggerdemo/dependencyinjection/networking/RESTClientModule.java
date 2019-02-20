package com.mkr.daggerdemo.dependencyinjection.networking;

import com.mkr.daggerdemo.utils.Constants;
import com.mkr.daggerdemo.networking.GitHubAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RESTClientModule {

    @Singleton
    @Provides
    Retrofit getClient() {

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
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
