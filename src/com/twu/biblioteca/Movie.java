package com.twu.biblioteca;

public class Movie implements Elements{

    private String title;
    private String director;
    private int year;
    private double rating;

    public Movie(String title, String director, int year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public void getDetails() {
        System.out.println(
                title + "   |   " + director +"   |   " + year+"   |   " + rating
        );
    }
    public String getTitle(){
        return title;
    }
}
