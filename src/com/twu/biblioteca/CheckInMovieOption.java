package com.twu.biblioteca;

public class CheckInMovieOption implements Options{

    public String name() {
        return "Check in your Movie";
    }

    public void execute(Library library) {
        library.checkInElement();
    }


}
