package com.twu.biblioteca;

import com.twu.biblioteca.options.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListMoviesOptionTest {

    private ByteArrayOutputStream outputStream;
    private BibliotecaApp biblioteca;
    private Library library;
    private Login login;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        biblioteca = new BibliotecaApp();
        library = new Library(login);
        Elements m1 = new Movie("Awesome movie 1", "Director 1", 2017, 9.0);
        Elements m2 = new Movie("Awesome movie 2", "Director 2", 2016, 8.0);
        Elements m3 = new Movie("Awesome movie 3", "Director 3", 2015, 5.4);
        library.addElements(m1);
        library.addElements(m2);
        library.addElements(m3);
    }

    @Test
    public void ListOfAvailableMoviesIsDisplayedWithAllDetails(){
        MainMenu mainMenu = new MainMenu(library);
        mainMenu.executeOption(true, 2);
        assertEquals("List of available movies in the Library:\n" +
                "Title   |   Director  |   Year  |   Rating\n" +
                "Awesome movie 1   |   Director 1   |   2017   |   9.0\n" +
                "Awesome movie 2   |   Director 2   |   2016   |   8.0\n" +
                "Awesome movie 3   |   Director 3   |   2015   |   5.4\n", outputStream.toString());
    }
}