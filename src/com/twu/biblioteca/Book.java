package com.twu.biblioteca;

public class Book implements Elements{

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void getDetails() {
        System.out.println(
                title + "   |   " + author +"   |   " + year
        );
    }

    public String getTitle(){
        return title;
    }

}
