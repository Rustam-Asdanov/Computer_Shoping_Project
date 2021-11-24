package com.project.full.ComputerShoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
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
}
