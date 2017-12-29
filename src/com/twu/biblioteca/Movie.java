package com.twu.biblioteca;

public class Movie extends Elements{

    private String director;
    private double rating;

    public Movie(String title, String director, int year, double rating){
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }
}
