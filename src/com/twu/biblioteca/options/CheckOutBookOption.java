package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class CheckOutBookOption implements Options {

    public String name() {
        return "Check out a Book";
    }

    public void execute(Library library) {
        library.printListOfBooks();
        library.checkOutElement();
    }


}
