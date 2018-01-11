package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WelcomeTest {

    private ByteArrayOutputStream outputStream;
    private BibliotecaApp biblioteca;

    //TODO: Do you really need setup here? It's only one single test
    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        biblioteca = new BibliotecaApp();
    }

    /*
        TODO: Method names in java start with a small letter.
     */
    @Test
    public void WelcomeMessageIsDisplayed(){
        biblioteca.welcomeMessage();
        assertEquals("WELCOME TO THE BANGALORE PUBLIC LIBRARY!\n\n", outputStream.toString());
    }
}