package com.mkr.daggerdemo.networking.models;

import com.google.gson.annotations.SerializedName;

public class RepoDetails {

    @SerializedName("id")
    long id;
    @SerializedName("name")
    String name;
    @SerializedName("full_name")
    String fullName;
    @SerializedName("html_url")
    String url;
    @SerializedName("description")
    String description;
    @SerializedName("language")
    String language;
    @SerializedName("owner")
    RepoOwner owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public RepoOwner getOwner() {
        return owner;
    }

    public void setOwner(RepoOwner owner) {
        this.owner = owner;
    }
}
