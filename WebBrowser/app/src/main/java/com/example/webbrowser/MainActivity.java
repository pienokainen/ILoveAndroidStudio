package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    WebView web;
    TextInputEditText urlInput;
    Button loadHTML;
    ImageButton searchButton, refreshButton, nextButton, previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlInput = findViewById(R.id.searchUrl);
        searchButton = findViewById(R.id.searchButton);
        refreshButton = findViewById(R.id.refreshButton);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        loadHTML = findViewById(R.id.loadHTML);
        web = findViewById(R.id.webView);


        if (savedInstanceState != null) {
            web.restoreState(savedInstanceState);
        } else {
            web.getSettings().setJavaScriptEnabled(true);
            web.getSettings().setUseWideViewPort(true);
            web.getSettings().setLoadWithOverviewMode(true);
            web.getSettings().setSupportZoom(true);
            web.getSettings().setSupportMultipleWindows(true);
            web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            web.setBackgroundColor(Color.WHITE);
        }
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://google.com");
    }
    public void onClickSearch(View v) {
        try {
            if (urlInput.getText().toString().equals("index.html")) {
                web.loadUrl("file:///android_asset/index.html");
                urlInput.setText("");
            } else {
                web.loadUrl("https://" + urlInput.getText().toString());
                urlInput.setText("");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onClickGoBack(View v) {
        if (web.canGoBack()) {
            web.goBack();
        }
    }
    public void onClickGoForward(View v) {
        if (web.canGoForward()) {
            web.goForward();
        }
    }
    public void onClickRefresh(View v) {
        web.reload();
    }
    public void onClickLoadHTML(View v) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

}

