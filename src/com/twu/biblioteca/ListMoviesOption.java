package com.twu.biblioteca;

public class ListMoviesOption implements Options{

    public String name() {
        return "List of available Movies";
    }

    public void execute(Library library) {
        library.printListOfMovies();
    }


}
