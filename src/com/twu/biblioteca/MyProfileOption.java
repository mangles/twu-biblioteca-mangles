package com.twu.biblioteca;

public class MyProfileOption implements Options{

    public String name() {
        return "See my profile information";
    }

    public void execute(Library library) {
        library.getUserLogged();

    }

}
