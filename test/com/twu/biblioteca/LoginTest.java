package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private Login login;

    @Before
    public void setUp(){

        login = new Login();
        User u1 = new User("189-2017", "MyPassword1");
        User u2 = new User("814-2012", "MyPassword2");
        login.addUsers(u1);
        login.addUsers(u2);
    }

    @Test
    public void ValidUserAndPassword(){
        assertEquals(true, login.validateLogin("189-2017", "MyPassword1"));
    }

    @Test
    public void WrongUserAndPassword(){
        assertEquals(false, login.validateLogin("189-2017", "MyPassword2"));

    }

}