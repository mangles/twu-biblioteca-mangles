package com.twu.biblioteca;

//TODO: How does elements represent domain? What does it mean in this context?
public class Elements {

    private String title;
    private int year;
    //TODO: Unused fields
    private String author;
    private String director;
    private double rating;

    public Elements(String title, int year){
        this.title = title;
        this.year = year;
    }


    //TODO: Do we need getters? If so, why?
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
