package com.twu.biblioteca;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {
    private Library library;
    private Map<Integer, Options> options = new HashMap<Integer, Options>();

    public MainMenu(Library library){
        this.library = library;
        options.put(1, new ListBooksOption());
        options.put(2, new CheckOutOption());
        options.put(3, new CheckInOption());
        options.put(4, new QuitProgramOption());
    }

    public void showListOfOptions(){
        System.out.println(Enumerations.Messages.HELP);

        for (Object key : options.keySet()) {
            System.out.println(key.toString() + " - "
                    + options.get(key).name());
        }
    }

    public void selectOption(){
        showListOfOptions();
        Scanner reader = new Scanner(System.in);
        int selectedOption = reader.nextInt();
        isValidOption(selectedOption);
        selectOption();
    }

    public void isValidOption(int selectedOption){
        boolean isValid = options.containsKey(selectedOption);
        executeOption(isValid, selectedOption);
    }

    public void executeOption(boolean isValid, int selectedOption){
        if(isValid){
            options.get(selectedOption).execute(library);
        }else{
            System.out.println(Enumerations.Messages.INVALID_OPTION);

        }
    }
}
