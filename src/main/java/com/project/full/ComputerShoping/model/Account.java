package com.project.full.ComputerShoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private int id;
    private String username;
    private String password;
    private String full_name;
    private String email;
    private String phone_number;

    public Account() {
    }
}
