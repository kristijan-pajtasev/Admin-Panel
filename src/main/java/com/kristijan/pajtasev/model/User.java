package com.kristijan.pajtasev.model;

import javax.persistence.*;

/**
 * Created by kristijan on 26.11.14..
 */
@Entity
@Table(name="user", schema="public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
