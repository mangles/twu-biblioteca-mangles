package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckInOptionTest {

    private BibliotecaApp biblioteca;
    private Library library;

    @Before
    public void setUp(){
        biblioteca = new BibliotecaApp();
        library = new Library();
    }

    @Test
    public void CheckInOptionIsListed() {
        CheckInOption checkIn = new CheckInOption();
        assertEquals("Check in your Book", checkIn.name());

    }

    @Test
    public void ReturnBookFromCheckedOutBooks(){
        ArrayList<Book> booksList;
        booksList = biblioteca.defineSomeBooks();
        library.addBooks(booksList);
        ByteArrayInputStream in = new ByteArrayInputStream("Awesome book 1".getBytes());
        System.setIn(in);
        library.checkOutBook();
        ByteArrayInputStream in2 = new ByteArrayInputStream("Awesome book 1".getBytes());
        System.setIn(in2);
        library.checkInBook();
        assertEquals(3, booksList.size());
        assertEquals(0, library.getCheckedOutbooks().size());

    }

    @Test
    public void BookToReturnNotFoundInLibrary(){
        ArrayList<Book> booksList;
        booksList = biblioteca.defineSomeBooks();
        library.addBooks(booksList);
        ByteArrayInputStream in = new ByteArrayInputStream("Book Awesome 1".getBytes());
        System.setIn(in);
        library.checkInBook();
        assertEquals(3, booksList.size());
        assertEquals(0, library.getCheckedOutbooks().size());

    }

}