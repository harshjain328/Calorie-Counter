package com.noobs.caloriecounter.models;

import com.google.gson.annotations.SerializedName;

public class LoginReq {
    @SerializedName("text")
    private String email;
    @SerializedName("text")
    private String password;

    public LoginReq(String email, String pass) {
        this.email = email;
        this.password = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }
}
