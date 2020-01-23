package com.example.linkedin.entity;

import javax.persistence.*;

@Table(name = "profile")
@Entity(name = "profile")

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "about")
    private String about;
    @Column(name = "designation")
    private String designation;
    @Column(name = "address")
    private String address;
    @Column(name = "user_id")
    private Long userId;
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private UserAccount userAccount;

    public Profile() {

    }

    public Profile(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public UserAccount getUserAccount() {
//        return userAccount;
//    }
//
//    public void setUserAccount(UserAccount userAccount) {
//        this.userAccount = userAccount;
//    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

