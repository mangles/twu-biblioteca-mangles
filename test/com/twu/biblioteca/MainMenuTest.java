package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private ByteArrayOutputStream outputStream;
    private MainMenu mainMenu;


    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Library library = new Library();
        mainMenu = new MainMenu(library);
    }

    @Test
    public void ShowListOfOptionsTheUserCanDo(){
        mainMenu.showListOfOptions();
        assertEquals("How can I help you? Select an option:\n" +
                "\n" +
                "1 - List of available Books\n" +
                "2 - List of available Movies\n" +
                "3 - Check out a Book\n" +
                "4 - Check in your Book\n" +
                "5 - Check out a Movie\n" +
                "6 - Check in your Movie\n" +
                "7 - Quit Program\n", outputStream.toString());
    }

    @Test
    public void ShouldThrowExceptionIfUserSelectsANotAValidOption(){
        mainMenu.isValidOption(100);
        assertEquals("Select a valid option!\n\n", outputStream.toString());
    }
}