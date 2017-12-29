package com.twu.biblioteca;

public class CheckOutMovieOption implements Options{

    public String name() {
        return "Check out a Movie";
    }

    public void execute(Library library) {
        library.printListOfMovies();
        library.checkOutElement();
    }


}
