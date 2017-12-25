package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> listOfbooks;


    public void addBooks(ArrayList<Book> books) {
        listOfbooks = books;
    }

    public void printListOfBooks(){
        System.out.println(Enumerations.Messages.AVAILABLE_BOOKS);
        System.out.println(Enumerations.Messages.INFO_BOOKS);
        for (Book b : listOfbooks){
            System.out.println(
                    b.getTitle() + "   |   " + b.getAuthor() +"   |   " + b.getYear()
            );
        }
    }
}
