package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private ByteArrayOutputStream outputStream;
    private BibliotecaApp biblioteca;
    private Library library;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        biblioteca = new BibliotecaApp();
        library = new Library();
    }

    @Test
    public void ListOfAvailableBooksIsDisplayed(){
        ArrayList<Book> booksList;
        booksList = biblioteca.defineSomeBooks();
        library.addBooks(booksList);
        library.printListOfBooks();
        assertEquals("List of available books in the Library:\n" +
                "Awesome book 1\n" +
                "Awesome book 2\n" +
                "Awesome book 3\n", outputStream.toString());
    }
}