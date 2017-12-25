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
    public void ListOfAvailableBooksIsDisplayedWithAllDetails(){
        ArrayList<Book> booksList;
        booksList = biblioteca.defineSomeBooks();
        library.addBooks(booksList);
        library.printListOfBooks();
        assertEquals("List of available books in the Library:\n" +
                "Title   |   Author  |   Year of publication\n" +
                "Awesome book 1   |   Author 1   |   2017\n" +
                "Awesome book 2   |   Author 2   |   2016\n" +
                "Awesome book 3   |   Author 3   |   2015\n", outputStream.toString());
    }
}