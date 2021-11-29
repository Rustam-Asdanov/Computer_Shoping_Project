package com.project.full.ComputerShoping.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String full_name;
    private String email;
    private String phone_number;
//    @OneToMany
//    private List<Computer> computerList;

    public Account() {
    }

    public Account(String username, String password, String full_name, String email, String phone_number) {
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.email = email;
        this.phone_number = phone_number;
    }
}
