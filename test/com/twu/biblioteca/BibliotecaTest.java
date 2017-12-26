package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaTest {

    private ByteArrayOutputStream outputStream;
    private BibliotecaApp biblioteca;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void WelcomeMessageIsDisplayed(){

        biblioteca.welcomeMessage();
        assertEquals("WELCOME TO THE BANGALORE PUBLIC LIBRARY!\n\n", outputStream.toString());
    }
}