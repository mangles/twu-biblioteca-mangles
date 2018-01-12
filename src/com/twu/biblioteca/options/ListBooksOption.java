package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class ListBooksOption implements Options {

    public String name() {
        return "List of available Books";
    }

    public void execute(Library library) {
        library.printListOfBooks();
    }


}
