package com.example.javavko8_bottledispenser;
import java.util.ArrayList;
import java.util.Locale;
import java.text.DecimalFormat;

public class BottleDispenser {
    private int bottles = 0;
    private double money;
    private ArrayList<Bottle> bottle_list;
    private static BottleDispenser single_instance=null;

    public static BottleDispenser getInstance() {
        if (single_instance == null)
        {
            single_instance = new BottleDispenser();
        }
        return single_instance;
    }

    private BottleDispenser() {
        money = 0;

        // Initialize the array
        bottle_list = new ArrayList<Bottle>();

        //Adding bottles to list
        Bottle bottle = new Bottle("Pepsi Max", "Pepsi", 0.5, 1.8);
        bottle_list.add(bottle);
        bottles++;

        bottle = new Bottle("Pepsi Max", "Pepsi", 1.5, 2.2);
        bottle_list.add(bottle);
        bottles++;

        bottle = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.5, 2.0);
        bottle_list.add(bottle);
        bottles++;

        bottle = new Bottle("Coca-Cola Zero", "Coca-Cola", 1.5, 2.5);
        bottle_list.add(bottle);
        bottles++;

        bottle = new Bottle("Fanta Zero", "Fanta", 0.5, 1.95);
        bottle_list.add(bottle);
        bottles++;

        bottle = new Bottle("Fanta Zero", "Fanta", 1.5, 2.40);
        bottle_list.add(bottle);
        bottles++;
    }

    public ArrayList<Bottle> getBottleList() {
        return bottle_list;
    }

    public Bottle getBottle(int index) {
        return bottle_list.get(index);
    }

    public int getBottlesLength() {
        return bottles;
    }

    public void printBottles() {
        int length = bottles;

        DecimalFormat df = new DecimalFormat("0.0#");
        for (int index = 0; index < length; index++) {
            Bottle bottle = getBottle(index);
            System.out.format("%d. Name: %s\n", 1+index, bottle.getName());
            System.out.format(Locale.US,
                    "       Size: %.1f	Price: %s\n", bottle.getEnergy(), df.format(bottle.getPrice()).replace(",", "."));
        }
    }

    public void addMoney(double addedMoney) {
        money += addedMoney;
    }

    public String buyBottle(int i) {
        Bottle bottle = bottle_list.get(i);
        double bottlePrice = bottle.getPrice();
        String bottleName = bottle.getName();

        if (money < bottlePrice) {
            return ("Add money first!");
        } else {
            bottles -= 1;
            bottle_list.remove(i);
            money -= bottlePrice;
            return ("KACHUNK! " + bottleName + " came out of the dispenser!");
        }
    }

    public void returnMoney() {
        money = 0;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double newMoney) {
        money = newMoney;
    }
}
