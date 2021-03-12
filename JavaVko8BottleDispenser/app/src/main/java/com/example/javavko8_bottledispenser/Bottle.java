package com.example.javavko8_bottledispenser;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double price;
    public Bottle(String bottleName, String manuf, double totE, double bottlePrice){
        name = bottleName;
        manufacturer = manuf;
        total_energy = totE;
        price = bottlePrice;
    }
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + total_energy + " l)" + "             " + price + " €";
    }
}