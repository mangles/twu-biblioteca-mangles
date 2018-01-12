package com.twu.biblioteca;

import com.twu.biblioteca.options.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListBooksOptionTest {

    private ByteArrayOutputStream outputStream;
    //TODO: This field is never used
    private BibliotecaApp biblioteca;
    private Library library;
    //TODO: This field is never used
    private Login login;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        biblioteca = new BibliotecaApp();
        //TODO: Since login is never initialized, it will be null. Can you not directly pass null here then?
        library = new Library(login);
        Elements b1 = new Book("Awesome book 1", "Author 1", 2017);
        Elements b2 = new Book("Awesome book 2", "Author 2", 2016);
        Elements b3 = new Book("Awesome book 3", "Author 3", 2015);
        library.addElements(b1);
        library.addElements(b2);
        library.addElements(b3);

    }

    @Test
    public void ListOfAvailableBooksIsDisplayedWithAllDetails(){
        MainMenu mainMenu = new MainMenu(library);
        mainMenu.executeOption(true, 1);
        assertEquals("List of available books in the Library:\n" +
                "Title   |   Author  |   Year of publication\n" +
                "Awesome book 1   |   Author 1   |   2017\n" +
                "Awesome book 2   |   Author 2   |   2016\n" +
                "Awesome book 3   |   Author 3   |   2015\n", outputStream.toString());
    }
}