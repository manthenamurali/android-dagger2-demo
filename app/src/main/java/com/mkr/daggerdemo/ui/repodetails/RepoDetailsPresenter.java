package com.mkr.daggerdemo.ui.repodetails;

import android.os.Bundle;

import com.google.gson.annotations.SerializedName;
import com.mkr.daggerdemo.networking.models.RepoDetails;
import com.mkr.daggerdemo.utils.Constants;

public class RepoDetailsPresenter implements RepoDetailsContract.Presenter {

    private RepoDetailsContract.View mView;

    RepoDetailsPresenter(RepoDetailsContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void getRepoDetails(Bundle repoDetailsBundle) {

        RepoDetailsToDisplay repoDetails = new RepoDetailsToDisplay();
        repoDetails.setName(repoDetailsBundle.getString(Constants.KEY_NAME));
        repoDetails.setAvatarURL(repoDetailsBundle.getString(Constants.KEY_AVATAR_URL));
        repoDetails.setDescription(repoDetailsBundle.getString(Constants.KEY_DESCRIPTION));
        repoDetails.setFullName(repoDetailsBundle.getString(Constants.KEY_FULL_NAME));
        repoDetails.setUrl(repoDetailsBundle.getString(Constants.KEY_URL));

        mView.displayRepoDetails(repoDetails);
    }

    public static class RepoDetailsToDisplay {

        private String name;
        private String fullName;
        private String url;
        private String description;
        private String avatarURL;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAvatarURL() {
            return avatarURL;
        }

        public void setAvatarURL(String avatarURL) {
            this.avatarURL = avatarURL;
        }
    }
}
