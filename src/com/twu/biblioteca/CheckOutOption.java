package com.twu.biblioteca;

public class CheckOutOption implements Options{

    public String name() {
        return "Check out a Book";
    }

    public void execute(Library library) {
        library.printListOfBooks();
        library.checkOutBook();
    }


}
