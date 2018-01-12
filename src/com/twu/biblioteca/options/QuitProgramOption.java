package com.twu.biblioteca.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.Options;

public class QuitProgramOption implements Options {

    public String name() {
        return "Quit Program";
    }

    public void execute(Library library) {
        System.exit(0);
    }


}
