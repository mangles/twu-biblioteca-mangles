package com.twu.biblioteca;

public class Elements {

    private String title;
    private int year;
    private String author;
    private String director;
    private double rating;

    public Elements(String title, int year){
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }
}
