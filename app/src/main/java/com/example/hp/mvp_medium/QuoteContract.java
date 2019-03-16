package com.example.hp.mvp_medium;

public interface QuoteContract {

    interface QuoteView {
        void showProgress();
        void hideProgress();
        void setQuote(Quote quote);

    }

     interface Presenter{
        void onChangeQuote();
     }

     interface GetQuoteInteractor {

        interface OnFinishedListener {
            void onSuccess(Quote quote);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }


}
