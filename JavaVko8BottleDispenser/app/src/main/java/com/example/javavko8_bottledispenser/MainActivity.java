package com.example.javavko8_bottledispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView text;
    SeekBar sBar;
    Spinner spinner;
    BottleDispenser bottleDispenser;
    Context context = null;
    String fileName = "receipt.txt";
    String lastPurchase = "# Bottle: Pepsi Max Price: 1€ #\n";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        sBar = (SeekBar) findViewById(R.id.seekBar);
        spinner = (Spinner) findViewById(R.id.spinner);
        bottleDispenser = BottleDispenser.getInstance();
        context = MainActivity.this;

        ArrayList<Bottle> bottles = bottleDispenser.getBottleList();

        ArrayAdapter<Bottle> adapter =
                new ArrayAdapter<Bottle>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, bottles);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void addMoney (View v){
        int money = sBar.getProgress();
        bottleDispenser.addMoney(money);
        DecimalFormat df = new DecimalFormat("0.#");
        text.setText("Klink! Added " + df.format(money) +"€ to machine! (" + df.format(bottleDispenser.getMoney()) + " total)");
        sBar.setProgress(0);
    }

    public void returnMoney (View v){
        double money = bottleDispenser.getMoney();
        text.setText("Klink klink. Money came out! You got "+  money + "€ back");
        bottleDispenser.returnMoney();
    }

    public void printReceipt(View v) {
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
            String info =   "########        RECEIPT        #########\n" +
                            "#                                      #\n" +
                            lastPurchase +
                            "#                                      #\n" +
                            "########                       #########\n";

            ows.write(info);
            text.setText("Receipt printed to file 'receipt.txt'");
            ows.close();
        } catch (Exception e) {
            Log.e("IOException", "Error occurred while printing receipt.");
        }
    }

    public void buyBottle(View v) {
        String info;
        ArrayList<Bottle> bottles = bottleDispenser.getBottleList();
        boolean state = bottles.isEmpty();
        try {
            if (!state) {
                int i = spinner.getSelectedItemPosition();
                info = bottleDispenser.buyBottle(i);
                ArrayAdapter<Bottle> adapter =
                        new ArrayAdapter<Bottle>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, bottles);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(adapter);
                Bottle bottle = bottles.get(i);
                double bottlePrice = bottle.getPrice();
                String bottleName = bottle.getName();
                lastPurchase = "# Bottle: " + bottleName + " | Price: " + bottlePrice + "€ #\n";
            } else {
                info = "No bottles left";
            }
            text.setText(info);
        } catch (Exception e) {
            Log.e("Exception", "Error occurred while buying bottle.");
        }
    }
}