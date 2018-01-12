package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class CheckOutMovieOption implements Options {

    public String name() {
        return "Check out a Movie";
    }

    public void execute(Library library) {
        library.printListOfMovies();
        library.checkOutElement();
    }


}
