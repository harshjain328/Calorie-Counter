package com.noobs.caloriecounter.models;

import com.google.gson.annotations.SerializedName;

public class LoginResp {

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private UserDetails user;

    public LoginResp(boolean status,UserDetails user) {
        this.status = status;
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
}
