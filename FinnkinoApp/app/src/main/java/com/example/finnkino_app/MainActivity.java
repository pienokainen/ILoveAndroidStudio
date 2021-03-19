package com.example.finnkino_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    RecyclerView recyclerView;
    private ArrayList<Theatre> theaters;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        spinner = (Spinner) findViewById(R.id.theater);
         recyclerView = (RecyclerView) findViewById(R.id.movies);

        theaters = new ArrayList<Theatre>();
        readAreasXML();
        ArrayAdapter<Theatre> adapter =
                new ArrayAdapter<Theatre>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, theaters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        movies = new ArrayList<Movie>();
        readScheduleXML();
    }

    public void readAreasXML() {
        try {
            //Reading Areas XML
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();

            URL url = new URL("https://www.finnkino.fi/xml/TheatreAreas/");
            InputStream stream = url.openStream();
            Document doc = docBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");
            Theatre theatre;
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String theatreName = element.getElementsByTagName("Name").item(0).getTextContent();
                    int theatreID = Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent());
                    theatre = new Theatre(theatreName, theatreID);
                    theaters.add(theatre);
                }
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void readScheduleXML() {
        try {
            int userChoice = spinner.getSelectedItemPosition();
            Theatre theatreInfo = theaters.get(userChoice);
            int selectedTheatreID = theatreInfo.getID();

            // Reading Schedule XML
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();

            URL url = new URL("https://www.finnkino.fi/xml/Schedule/?area=" + selectedTheatreID + "&dt=20.03.2021");
            InputStream stream = url.openStream();
            Document doc = docBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Show");
            Movie movie;
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String movieName = element.getElementsByTagName("Title").item(0).getTextContent();
                    String imageURL = element.getElementsByTagName("EventSmallImagePortrait").item(0).getTextContent();
                    String showStart = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                    String showEnd = element.getElementsByTagName("dttmShowEnd").item(0).getTextContent();
                    movie = new Movie(movieName, imageURL, showStart, showEnd);
                    movies.add(movie);
                }
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.finnkino.fi/"));
        startActivity(intent);
    }
}