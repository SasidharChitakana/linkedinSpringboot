package com.example.linkedin.entity;


import javax.persistence.*;
import java.util.List;

@Table(name = "skills")
@Entity(name = "skills")
public class Skills {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "skill_name")
    private String skillName;
    @Column(name = "user_id")
    private Long userId;
//    @ManyToOne()
//    @JoinColumn(name = "user_id")
//    private UserAccount userAccount;

    public Skills(Long id) {
        this.id = id;
    }

    public Skills() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

//    public UserAccount getUserAccount() {
//        return userAccount;
//    }
//
//    public void setUserAccount(UserAccount userAccount) {
//        this.userAccount = userAccount;
//    }
}
