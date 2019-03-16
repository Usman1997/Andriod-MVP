package com.example.hp.mvp_medium;

public class QuotePresenter implements QuoteContract.GetQuoteInteractor.OnFinishedListener, QuoteContract.Presenter {

    private QuoteContract.QuoteView quoteView;
    private QuoteContract.GetQuoteInteractor quoteInteractor;

    public QuotePresenter(QuoteContract.QuoteView quoteView, QuoteContract.GetQuoteInteractor quoteInteractor) {
        this.quoteView = quoteView;
        this.quoteInteractor = quoteInteractor;
    }

    @Override
    public void onChangeQuote() {
        quoteView.showProgress();
        quoteInteractor.getNextQuote(this);
    }

    @Override
    public void onSuccess(Quote quote) {
        quoteView.hideProgress();
        quoteView.setQuote(quote);
    }
}
