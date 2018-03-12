package com.sevena.backend.usertest;

import org.springframework.data.annotation.Id;

public class UserTest {
    @Id
    private final String id;
    
    public UserTest(String id) {
        this.id = id;
    }
}
