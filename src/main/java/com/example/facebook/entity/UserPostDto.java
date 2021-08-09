package com.example.facebook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPostDto {

    @JsonProperty
    private String userName;
    @JsonProperty
    private String userEmail;
    @JsonProperty
    private int userLikes;
    @JsonProperty
    private String userComments;
    @JsonProperty
    private String userShare;

    public UserPostDto() {
    }

    public UserPostDto(String userName, int userLikes, String userComments, String userShare) {
        this.userName = userName;

        this.userLikes = userLikes;
        this.userComments = userComments;
        this.userShare = userShare;
    }

    public UserPostDto(String userName, String userEmail, int userLikes, String userComments, String userShare) {
        this.userName = userName;
        this.userEmail=userEmail;
        this.userLikes = userLikes;
        this.userComments = userComments;
        this.userShare = userShare;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(int userLikes) {
        this.userLikes = userLikes;
    }

    public String getUserComments() {
        return userComments;
    }

    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }

    public String getUserShare() {
        return userShare;
    }

    public void setUserShare(String userShare) {
        this.userShare = userShare;
    }
}
