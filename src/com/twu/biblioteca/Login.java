package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Login {
    private ArrayList<User> listOfUsers = new ArrayList<User>();


    public void addUsers(User users){
        Collections.addAll(listOfUsers, users);
    }

    public boolean authenticateUser() {
        System.out.println(Enumerations.Messages.LOGIN_USER);
        String libraryNumber = askforInput();
        System.out.println(Enumerations.Messages.LOGIN_PASSWORD);
        String password = askforInput();
        return validateLogin(libraryNumber, password);

    }

    public boolean validateLogin(String libraryNumber, String password) {
        boolean isValid = false;
        for(User user : listOfUsers) {
            if(libraryNumber.equals(user.getLibraryNumber()) && password.equals(user.getPassword()))
                isValid = true;
        }
        return isValid;
    }

    private String askforInput() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
