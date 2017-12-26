package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private ByteArrayOutputStream outputStream;
    private MainMenu mainMenu;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        mainMenu = new MainMenu();
    }

    @Test
    public void ShowListOfOptionsTheUserCanDo(){
        mainMenu.showListOfOptions();
        assertEquals("How can I help you? Select an option:\n" +
                "1 - List of available Books\n", outputStream.toString());
    }
}