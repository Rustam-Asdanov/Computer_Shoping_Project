package com.project.full.ComputerShoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String full_name;
    private String email;
    private String phone_number;

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
