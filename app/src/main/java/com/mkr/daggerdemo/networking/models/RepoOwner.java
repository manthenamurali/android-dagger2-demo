package com.mkr.daggerdemo.networking.models;

import com.google.gson.annotations.SerializedName;

public class RepoOwner {

    @SerializedName("avatar_url")
    String avatarURL;

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
