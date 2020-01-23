package com.example.linkedin.models;

public class WebProfile {

    private String about;
    private String designation;
    private String address;
    private Long userId;

    public WebProfile() {

    }

    public WebProfile(String about, String designation, String address) {
        this.about = about;
        this.designation = designation;
        this.address = address;
    }

    public WebProfile(Long userId) {
        this.userId = userId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
