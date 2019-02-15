package com.mkr.daggerdemo.ui.repodetails;

import android.os.Bundle;

import com.mkr.daggerdemo.utils.Constants;

public class RepoDetailsPresenter implements RepoDetailsContract.Presenter {

    private RepoDetailsContract.View mView;
    private RepoDetailsToDisplay mRepoDetails;

    RepoDetailsPresenter(RepoDetailsContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void getRepoDetails(Bundle repoDetailsBundle) {

        mRepoDetails = new RepoDetailsToDisplay();
        mRepoDetails.setName(repoDetailsBundle.getString(Constants.KEY_NAME));
        mRepoDetails.setAvatarURL(repoDetailsBundle.getString(Constants.KEY_AVATAR_URL));
        mRepoDetails.setDescription(repoDetailsBundle.getString(Constants.KEY_DESCRIPTION));
        mRepoDetails.setFullName(repoDetailsBundle.getString(Constants.KEY_FULL_NAME));
        mRepoDetails.setUrl(repoDetailsBundle.getString(Constants.KEY_URL));

        mView.displayRepoDetails(mRepoDetails);
    }

    public String getRepoUrl() {
        return mRepoDetails.getUrl();
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
