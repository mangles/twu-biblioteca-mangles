package com.twu.biblioteca;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {
    private Map<Integer, ListBooksOption> options = new HashMap<Integer, ListBooksOption>();

    public MainMenu(){
        options.put(1, new ListBooksOption());
    }

    public void showListOfOptions(){
        System.out.println(Enumerations.Messages.HELP);

        for (Object key : options.keySet()) {
            System.out.println(key.toString() + " - "
                    + options.get(key).name());
        }
    }

    public void selectOption(Library library){
        showListOfOptions();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        options.get(n).execute(library);

    }
}
