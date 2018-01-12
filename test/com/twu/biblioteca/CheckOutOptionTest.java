package com.twu.biblioteca;

import com.twu.biblioteca.options.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class CheckOutOptionTest {

    private BibliotecaApp biblioteca;
    private Library library;
    private Login login;

    @Before
    public void setUp(){
        biblioteca = new BibliotecaApp();
        library = new Library(login);
        Elements b1 = new Book("Awesome book 1", "Author 1", 2017);
        Elements b2 = new Book("Awesome book 2", "Author 2", 2016);
        Elements b3 = new Book("Awesome book 3", "Author 3", 2015);
        library.addElements(b1);
        library.addElements(b2);
        library.addElements(b3);
    }

    @Test
    public void CheckOutOptionIsListed() {
        CheckOutBookOption checkOut = new CheckOutBookOption();
        assertEquals("Check out a Book", checkOut.name());

    }

    @Test
    public void RemoveBookFromAvailableBooks(){
        ByteArrayInputStream in = new ByteArrayInputStream("Awesome book 1".getBytes());
        System.setIn(in);
        library.checkOutElement();
        assertEquals(2, library.getAvailableElements().size());
        assertEquals(1, library.getCheckedOutElements().size());

    }

    @Test
    public void BookNotFoundInLibrary(){
        ByteArrayInputStream in = new ByteArrayInputStream("Book Awesome 1".getBytes());
        System.setIn(in);
        library.checkOutElement();
        assertEquals(3, library.getAvailableElements().size());
        assertEquals(0, library.getCheckedOutElements().size());

    }

}