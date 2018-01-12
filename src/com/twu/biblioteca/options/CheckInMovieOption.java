package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class CheckInMovieOption implements Options {

    public String name() {
        return "Check in your Movie";
    }

    public void execute(Library library) {
        library.checkInElement();
    }


}
