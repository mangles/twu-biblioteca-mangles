package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class MyProfileOption implements Options {

    public String name() {
        return "See my profile information";
    }

    public void execute(Library library) {
        library.getUserLogged();

    }

}
