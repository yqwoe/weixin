package com.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_department")
public class UserDepartment {

    @Id
    @GeneratedValue
    Long id;
    Long user_id;
    Long department_id;

    public UserDepartment() {
    }

    public UserDepartment(Long user_id, Long department_id) {
        this.user_id = user_id;
        this.department_id = department_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }
}
