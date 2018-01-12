package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library {
    private ArrayList<Elements> checkedOutElements = new ArrayList<Elements>();
    private ArrayList<Elements> availableElements = new ArrayList<Elements>();
    private Login login;

    public Library(Login login){
        this.login = login;
    }


    public ArrayList<Elements> getCheckedOutElements(){
        return checkedOutElements;
    }

    public ArrayList<Elements> getAvailableElements(){
        return availableElements;
    }

    public void addElements(Elements element){
        Collections.addAll(availableElements, element);
    }

    private ArrayList<Elements> books(){
        ArrayList<Elements> books = new ArrayList<Elements>();
        for(Elements item : availableElements){
            if(item instanceof Book){
                books.add(item);
            }
        }
        return books;
    }

    private ArrayList<Elements> movies(){
        ArrayList<Elements> movies = new ArrayList<Elements>();
        for(Elements item : availableElements){
            if(item instanceof Movie){
                movies.add(item);
            }
        }
        return movies;
    }

    public void printListOfBooks(){
        ArrayList<Elements> booksList = books();
        printDetails(Enumerations.Messages.AVAILABLE_BOOKS, Enumerations.Messages.INFO_BOOKS, booksList);
    }

    public void printListOfMovies(){
        ArrayList<Elements> moviesList = movies();
        printDetails(Enumerations.Messages.AVAILABLE_MOVIES, Enumerations.Messages.INFO_MOVIES, moviesList);
    }

    private void printDetails(String availableMessage, String infoMessage, ArrayList<Elements> elements) {
        System.out.println(availableMessage);
        System.out.println(infoMessage);
        for (Elements item : elements){
            item.getDetails();
        }
    }

    public void checkOutElement(){
        String title = askElementTitle();
        Elements elementToCheckOut = findElementByTitle(title, availableElements);
        if (elementToCheckOut == null){
            System.out.println(Enumerations.Messages.ELEMENT_NOT_FOUND);
        }else{
            availableElements.remove(elementToCheckOut);
            checkedOutElements.add(elementToCheckOut);
            System.out.println(Enumerations.Messages.THANK_YOU);
        }
    }
    private String askElementTitle() {
        System.out.println(Enumerations.Messages.ENTER_TITLE);
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    private Elements findElementByTitle(String title, ArrayList listofItems) {
        for (Elements b : new ArrayList<Elements>(listofItems)) {
            if(b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }

    public void checkInElement() {
        String title = askElementTitle();
        Elements elementToCheckIn = findElementByTitle(title, checkedOutElements);
        if (elementToCheckIn == null){
            System.out.println(Enumerations.Messages.ELEMENT_NOT_KNOWN);
        }else{
            checkedOutElements.remove(elementToCheckIn);
            availableElements.add(elementToCheckIn);
            System.out.println(Enumerations.Messages.ELEMENT_RETURNED);
        }
    }

    public void getUserLogged() {
        System.out.println(
                        "Username: " + login.getCurrentUser().getName() + "\n" +
                        "Email: " + login.getCurrentUser().getEmail() + "\n" +
                        "Phone: " + login.getCurrentUser().getPhone()+ "\n"
        );
    }
}
