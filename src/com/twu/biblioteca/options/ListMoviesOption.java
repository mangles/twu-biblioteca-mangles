package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class ListMoviesOption implements Options {

    public String name() {
        return "List of available Movies";
    }

    public void execute(Library library) {
        library.printListOfMovies();
    }


}
