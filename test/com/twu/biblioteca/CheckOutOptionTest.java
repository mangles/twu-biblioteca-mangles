package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckOutOptionTest {

    private BibliotecaApp biblioteca;
    private Library library;

    @Before
    public void setUp(){
        biblioteca = new BibliotecaApp();
        library = new Library();
    }

    @Test
    public void CheckOutOptionIsListed() {
        CheckOutOption checkOut = new CheckOutOption();
        assertEquals("Check out a Book", checkOut.name());

    }

    @Test
    public void RemoveBookFromAvailableBooks(){
        ArrayList<Book> booksList;
        ArrayList<Book> checkedOutbooks = new ArrayList<Book>();
        booksList = biblioteca.defineSomeBooks();
        library.addBooks(booksList);
        ByteArrayInputStream in = new ByteArrayInputStream("Awesome book 1".getBytes());
        System.setIn(in);
        library.checkOutBook();
        assertEquals(2, booksList.size());
        assertEquals(1, library.getCheckedOutbooks().size());

    }

    @Test
    public void BookNotFoundInLibrary(){
        ArrayList<Book> booksList;
        ArrayList<Book> checkedOutbooks = new ArrayList<Book>();
        booksList = biblioteca.defineSomeBooks();
        library.addBooks(booksList);
        ByteArrayInputStream in = new ByteArrayInputStream("Book Awesome 1".getBytes());
        System.setIn(in);
        library.checkOutBook();
        assertEquals(3, booksList.size());
        assertEquals(0, library.getCheckedOutbooks().size());

    }

}