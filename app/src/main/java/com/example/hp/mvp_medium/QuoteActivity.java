package com.example.hp.mvp_medium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteActivity extends AppCompatActivity implements QuoteContract.QuoteView {
    TextView quoteTxt;
    ProgressBar progressBar;
    Button button;
    QuotePresenter quotePresenter;
    TextView authorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        quoteTxt = (TextView) findViewById(R.id.quote);
        authorName  =(TextView)findViewById(R.id.authorName);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button = (Button) findViewById(R.id.button);

        initializePresenter();
        quotePresenter.onChangeQuote();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quoteTxt.setText("");
                authorName.setText("");
                quotePresenter.onChangeQuote();
            }
        });


    }

    private void initializePresenter() {
        quotePresenter = new QuotePresenter(this, new QuoteInteractorImpl());
    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setQuote(Quote quote) {
        quoteTxt.setText(quote.getQuote());
        authorName.setText(quote.getAuthor());
    }
}
