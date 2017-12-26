package com.twu.biblioteca;

public class ListBooksOption {

    public String name() {
        return "List of available Books";
    }

    public void execute(Library library) {
        library.printListOfBooks();
    }


}
