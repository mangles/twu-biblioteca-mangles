package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library {
    private ArrayList<Elements> checkedOutElements = new ArrayList<Elements>();
    private ArrayList<Elements> AvailableElements = new ArrayList<Elements>();
    private Login login;

    public Library(Login login){
        this.login = login;
    }


    public ArrayList<Elements> getCheckedOutElements(){
        return checkedOutElements;
    }

    public ArrayList<Elements> getAvailableElements(){
        return AvailableElements;
    }

    public void addElements(Elements element){
        Collections.addAll(AvailableElements, element);
    }

    private ArrayList<Elements> books(){
        ArrayList<Elements> books = new ArrayList<Elements>();
        for(Elements item : AvailableElements){
            if(item instanceof Book){
                books.add(item);
            }
        }
        return books;
    }

    private ArrayList<Elements> movies(){
        ArrayList<Elements> movies = new ArrayList<Elements>();
        for(Elements item : AvailableElements){
            if(item instanceof Movie){
                movies.add(item);
            }
        }
        return movies;
    }

    public void printListOfBooks(){
        System.out.println(Enumerations.Messages.AVAILABLE_BOOKS);
        System.out.println(Enumerations.Messages.INFO_BOOKS);
        for (Elements b : books()){
            System.out.println(
                    b.getTitle() + "   |   " + b.getAuthor() +"   |   " + b.getYear()
            );
        }
    }

    public void printListOfMovies() {
        System.out.println(Enumerations.Messages.AVAILABLE_MOVIES);
        System.out.println(Enumerations.Messages.INFO_MOVIES);
        for (Elements m : movies()){
            System.out.println(
                    m.getTitle() + "   |   " + m.getDirector() +"   |   " + m.getYear()+"   |   " + m.getRating()
            );
        }
    }

    public void checkOutElement(){
        String title = askElementTitle();
        Elements elementToCheckOut = findElementByTitle(title, AvailableElements);
        if (elementToCheckOut == null){
            System.out.println(Enumerations.Messages.ELEMENT_NOT_FOUND);
        }else{
            AvailableElements.remove(elementToCheckOut);
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
            AvailableElements.add(elementToCheckIn);
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
