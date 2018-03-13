package com.models;

import javax.persistence.*;

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Long parentid;
    @Column(name="order_id")
    int order;

    public Department() {
    }

    public Department(Long id, String name, Long parentid, int order) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
