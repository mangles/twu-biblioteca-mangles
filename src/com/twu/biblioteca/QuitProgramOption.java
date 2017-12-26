package com.twu.biblioteca;

public class QuitProgramOption implements Options{

    public String name() {
        return "Quit Program";
    }

    public void execute(Library library) {
        System.exit(0);
    }


}
