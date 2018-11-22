package com.noobs.caloriecounter.models;


import java.util.Date;

public class UserDetails {
    private String email;
    private String uname;
    private String password;
    private Double height;
    private Double weight;
    private String activity_level;
    private String goal;
    private Integer budget;
    private Integer frequency;
    private String gender;
    private Double bmi;
    private Date dob;
    private Integer consumed;
    private Integer burnt;
    private Double goalweight ;
    private Double goalperweek;

    public UserDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getActivity_level() {
        return activity_level;
    }

    public void setActivity_level(String activity_level) {
        this.activity_level = activity_level;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getConsumed() {
        return consumed;
    }

    public void setConsumed(Integer consumed) {
        this.consumed = consumed;
    }

    public Integer getBurnt() {
        return burnt;
    }

    public void setBurnt(Integer burnt) {
        this.burnt = burnt;
    }

    public Double getGoalweight() {
        return goalweight;
    }

    public void setGoalweight(Double goalweight) {
        this.goalweight = goalweight;
    }

    public Double getGoalperweek() {
        return goalperweek;
    }

    public void setGoalperweek(Double goalperweek) {
        this.goalperweek = goalperweek;
    }

    public UserDetails(String email, String uname, String password, Double height, Double weight, String activity_level, String goal, Integer budget, Integer frequency, String gender, Double bmi, Date dob, Integer consumed, Integer burnt, Double goalweight, Double goalperweek) {
        this.email = email;
        this.uname = uname;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.activity_level = activity_level;
        this.goal = goal;
        this.budget = budget;
        this.frequency = frequency;
        this.gender = gender;
        this.bmi = bmi;
        this.dob = dob;
        this.consumed = consumed;
        this.burnt = burnt;
        this.goalweight = goalweight;
        this.goalperweek = goalperweek;
    }
}
