package com.example.hp.mvp_medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Handler;

public class QuoteInteractorImpl implements QuoteContract.GetQuoteInteractor {

    private List<Quote> quoteList = new ArrayList<>();


    @Override
    public void getNextQuote(final OnFinishedListener onFinishedListener) {
        setQuotes();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onSuccess(getRandomQuote());
            }
        }, 1200);
    }


    private void setQuotes() {
        Quote quote1 = new Quote("Our greatest glory is not in never falling, but in rising every time we fall", "- Confucius");
        quoteList.add(quote1);
        Quote quote2 = new Quote("All our dreams can come true, if we have the courage to pursue them", " – Walt Disney");
        quoteList.add(quote2);
        Quote quote3 = new Quote("It does not matter how slowly you go as long as you do not stop.", "– Confucius");
        quoteList.add(quote3);
        Quote quote4 = new Quote(" Everything you’ve ever wanted is on the other side of fear.", "— George Addair");
        quoteList.add(quote4);
        Quote quote5 = new Quote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "– Winston Churchill");
        quoteList.add(quote5);

    }

    private Quote getRandomQuote() {

        Random random = new Random();
        int index = random.nextInt(quoteList.size());
        return quoteList.get(index);
    }
}
