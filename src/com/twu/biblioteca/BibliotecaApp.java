package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> booksList = new ArrayList<Book>();

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.setup();

    }
    private void setup(){
        welcomeMessage();
        Library library = new Library();
        booksList = defineSomeBooks();
        library.addBooks(booksList);
        MainMenu mainMenu = new MainMenu(library);
        mainMenu.selectOption();

    }

    public void welcomeMessage() {
        System.out.println(Enumerations.Messages.WELCOME);

    }
    public ArrayList<Book> defineSomeBooks(){
        Book b1 = new Book("Awesome book 1", "Author 1", 2017);
        Book b2 = new Book("Awesome book 2", "Author 2", 2016);
        Book b3 = new Book("Awesome book 3", "Author 3", 2015);
        booksList.add(b1);
        booksList.add(b2);
        booksList.add(b3);
        return booksList;

    }
}
