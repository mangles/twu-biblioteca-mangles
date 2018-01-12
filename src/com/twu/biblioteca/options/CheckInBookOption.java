package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class CheckInBookOption implements Options {

    public String name() {
        return "Check in your Book";
    }

    public void execute(Library library) {
        library.checkInElement();
    }


}
