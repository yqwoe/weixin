package com.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String userid;
    @Column
    String english_name;
    @Column
    String mobile;
    @Transient
    Set<Department> department =new HashSet<Department>();
    @Column
    String position;
    @Column
    String gender;
    @Column
    String email;
    @Column
    Long isLeader;
    @Column
    Long enable;
    @Column
    String avatar_mediaid;
    @Column
    String telephone;
    @Column
    boolean to_invite;
    @Column
    String name;

    public User() {
    }

    public User(String userid, String english_name, String mobile, Set<Department> department, String position, String gender, String email, Long isLeader, Long enable, String avatar_mediaid, String telephone, boolean to_invite, String name) {
        this.userid = userid;
        this.english_name = english_name;
        this.mobile = mobile;
        this.department = department;
        this.position = position;
        this.gender = gender;
        this.email = email;
        this.isLeader = isLeader;
        this.enable = enable;
        this.avatar_mediaid = avatar_mediaid;
        this.telephone = telephone;
        this.to_invite = to_invite;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    @JoinTable(name="user_department",joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="department_id",referencedColumnName = "id")})
    public void setDepartment(Set<Department> department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Long isLeader) {
        this.isLeader = isLeader;
    }

    public Long getEnable() {
        return enable;
    }

    public void setEnable(Long enable) {
        this.enable = enable;
    }

    public String getAvatar_mediaid() {
        return avatar_mediaid;
    }

    public void setAvatar_mediaid(String avatar_mediaid) {
        this.avatar_mediaid = avatar_mediaid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isTo_invite() {
        return to_invite;
    }

    public void setTo_invite(boolean to_invite) {
        this.to_invite = to_invite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
