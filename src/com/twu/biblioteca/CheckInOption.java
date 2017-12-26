package com.twu.biblioteca;

public class CheckInOption implements Options{

    public String name() {
        return "Check in your Book";
    }

    public void execute(Library library) {
        library.checkInBook();
    }


}
