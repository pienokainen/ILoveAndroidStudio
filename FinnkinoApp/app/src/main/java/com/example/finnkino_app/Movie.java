package com.example.finnkino_app;

public class Movie {
    private String name;
    private String img;
    private String start;
    private String end;
    public Movie(String movieName, String imageUrl, String showStart, String showEnd) {
        name = movieName;
        img = imageUrl;
        start = showStart;
        end = showEnd;
    }
    public String getName(){
        return name;
    }
    public String getImg() {
        return img;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
}
