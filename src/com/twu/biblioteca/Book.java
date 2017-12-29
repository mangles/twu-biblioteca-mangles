package com.twu.biblioteca;

public class Book extends Elements{

    private String author;

    public Book(String title, String author, int year){
        super(title, year);
        this.author = author;
    }

    @Override
    public String getAuthor() {
        return author;
    }

}
