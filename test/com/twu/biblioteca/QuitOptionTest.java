package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class QuitOptionTest {

    @Test
    public void QuitProgramOptionIsListed(){
        QuitProgramOption quit = new QuitProgramOption();
        assertEquals("Quit Program", quit.name());

    }

}