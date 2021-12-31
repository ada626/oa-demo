package com.yx.oa.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserService();
    @Test
    public void checkLogin() {
        userService.checkLogin("uu","1234");
    }
}