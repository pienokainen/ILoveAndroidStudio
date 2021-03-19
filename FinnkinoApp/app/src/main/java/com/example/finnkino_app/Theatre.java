package com.example.finnkino_app;

public class Theatre {
    private String name;
    private int id;

    public Theatre(String theatreName, int theatreID){
        name = theatreName;
        id = theatreID;
    }
    public String getName(){
        return name;
    }
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
