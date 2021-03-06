package com.twu.biblioteca;

import com.twu.biblioteca.options.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {
    private Library library;
    private Map<Integer, Options> options = new HashMap<Integer, Options>();

    public MainMenu(Library library){
        this.library = library;
        options.put(1, new ListBooksOption());
        options.put(2, new ListMoviesOption());
        options.put(3, new CheckOutBookOption());
        options.put(4, new CheckInBookOption());
        options.put(5, new CheckOutMovieOption());
        options.put(6, new CheckInMovieOption());
        options.put(7, new MyProfileOption());
        options.put(8, new QuitProgramOption());
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

    //TODO: Is this method being used outside this class?
    public void isValidOption(int selectedOption){
        boolean isValid = options.containsKey(selectedOption);
        executeOption(isValid, selectedOption);
    }

    public void executeOption(boolean isValid, int selectedOption){
        if(isValid){options.get(selectedOption).execute(library);}
        System.out.println(Enumerations.Messages.INVALID_OPTION);
    }
}
