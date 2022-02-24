package com.gwsh.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final Long    serialVersionUID = 1L;
    private              Integer id;
    private              String  username;
    private              String  addrees;

    public User(Integer id, String username, String addrees) {
        this.id = id;
        this.username = username;
        this.addrees = addrees;
    }
}
