package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MyProfileOptionTest {

    private ByteArrayOutputStream outputStream;
    private Login login;
    private Library library;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        login = new Login();
        User u1 = new User("189-2017", "MyPassword1", "Mireia", "a@a.com", 612345678);
        User u2 = new User("814-2012", "MyPassword2", "Mireia", "b@b.com", 698765432);
        login.addUsers(u1);
        login.addUsers(u2);
        login.validateLogin("189-2017", "MyPassword1");
        library = new Library(login);
    }

    @Test
    public void MyProfileOptionIsListed(){
        MyProfileOption profile = new MyProfileOption();
        assertEquals("See my profile information", profile.name());

    }

    @Test
    public void ShowMyProfileInformation() {
        MainMenu mainMenu = new MainMenu(library);
        mainMenu.executeOption(true, 7);
        assertEquals("Username: Mireia\n" +
                "Email: a@a.com\n" +
                "Phone: 612345678\n" +
                "\n", outputStream.toString());
    }

}