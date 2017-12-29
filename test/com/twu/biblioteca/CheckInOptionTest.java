package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class CheckInOptionTest {

    private BibliotecaApp biblioteca;
    private Library library;

    @Before
    public void setUp(){
        biblioteca = new BibliotecaApp();
        library = new Library();
        Elements b1 = new Book("Awesome book 1", "Author 1", 2017);
        Elements b2 = new Book("Awesome book 2", "Author 2", 2016);
        Elements b3 = new Book("Awesome book 3", "Author 3", 2015);
        library.addElements(b1);
        library.addElements(b2);
        library.addElements(b3);
    }

    @Test
    public void CheckInOptionIsListed() {
        CheckInBookOption checkIn = new CheckInBookOption();
        assertEquals("Check in your Book", checkIn.name());

    }

    @Test
    public void ReturnBookFromCheckedOutBooks(){
        ByteArrayInputStream in = new ByteArrayInputStream("Awesome book 1".getBytes());
        System.setIn(in);
        library.checkOutElement();
        ByteArrayInputStream in2 = new ByteArrayInputStream("Awesome book 1".getBytes());
        System.setIn(in2);
        library.checkInElement();
        assertEquals(3, library.getAvailableElements().size());
        assertEquals(0, library.getCheckedOutElements().size());

    }

    @Test
    public void BookToReturnNotFoundInLibrary(){
        ByteArrayInputStream in = new ByteArrayInputStream("Book Awesome 1".getBytes());
        System.setIn(in);
        library.checkInElement();
        assertEquals(3, library.getAvailableElements().size());
        assertEquals(0, library.getCheckedOutElements().size());

    }

}