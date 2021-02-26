package com.example.java_vko7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String filename;
    TextView text;
    TextInputEditText fileNameInput;
    TextInputEditText textInput;
    TextWatcher change_text;
    Context context = null;
    /*
    ImageView image;
    RotateAnimation rotateAnimation;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        textInput = (TextInputEditText) findViewById(R.id.textInput);
        fileNameInput = (TextInputEditText) findViewById(R.id.fileNameInput);
        context = MainActivity.this;

        /* RotateImageAnimation
        image = findViewById(R.id.imageView);

        rotateAnimation = new RotateAnimation(0, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        */

        change_text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filename = fileNameInput.getText().toString();
                text.setText(filename);
            }

            @Override
            public void afterTextChanged(Editable s) {
                text.setText(fileNameInput.getText());
            }
        };
        fileNameInput.addTextChangedListener(change_text);
    }

    public void readFile(View v) {
        try {
            InputStream ins = context.openFileInput(fileNameInput.getText().toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";
            while ((s=br.readLine()) != null) {
                textInput.setText(s + "\n");
            }
            ins.close();
        } catch (IOException e) {
            Log.e("IOException", "Error occurred while reading");
            e.printStackTrace();
        }
    }

    public void writeFile(View v) {
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(fileNameInput.getText().toString(), Context.MODE_PRIVATE));

            ows.write(textInput.getText().toString());
            ows.close();
            textInput.setText("");
        } catch (IOException e) {
            Log.e("IOException", "Error occurred while writing");
        }
    }

    /*
    public void buttonPress(View v) {

        text.setText("Hi you!");
        image.startAnimation(rotateAnimation);

    }
    */
}