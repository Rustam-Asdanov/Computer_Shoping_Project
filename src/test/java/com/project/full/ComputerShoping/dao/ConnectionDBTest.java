package com.project.full.ComputerShoping.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConnectionDBTest {

    private ConnectionDB connectionDB;

    @BeforeEach
    void setUp() {
        connectionDB = new ConnectionDB();
    }

    @Test
    void canGetConnection() {
        assertThat(connectionDB.getConnection()).isNotEqualTo(null);
    }

    @Test
    void getStatement() {
        assertThat(connectionDB.getStatement()).isNotEqualTo(null);
    }
}