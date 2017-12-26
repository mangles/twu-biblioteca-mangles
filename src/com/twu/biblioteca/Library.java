package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> listOfbooks;
    private ArrayList<Book> checkedOutbooks = new ArrayList<Book>();


    public void addBooks(ArrayList<Book> books) {
        listOfbooks = books;
    }

    public ArrayList<Book> getCheckedOutbooks(){
        return checkedOutbooks;
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
    public void checkOutBook(){
        String title = askBookTitle();
        Book bookToCheckOut = findBookByTitle(title);
        if (bookToCheckOut == null){
            System.out.println(Enumerations.Messages.BOOK_NOT_FOUND);
        }else{
            listOfbooks.remove(bookToCheckOut);
            checkedOutbooks.add(bookToCheckOut);
            System.out.println(Enumerations.Messages.THANK_YOU);
        }
    }

    private Book findBookByTitle(String title) {
        for (Book b : new ArrayList<Book>(listOfbooks)) {
            if(b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }

    private String askBookTitle() {
        System.out.println(Enumerations.Messages.ENTER_BOOK_TITLE);
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
