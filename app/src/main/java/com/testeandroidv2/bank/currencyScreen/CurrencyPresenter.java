package com.testeandroidv2.bank.currencyScreen;

import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

interface CurrencyPresenterInput {
    public void presentCurrencyData(CurrencyResponse response);
}


public class CurrencyPresenter implements CurrencyPresenterInput {

    public static String TAG = CurrencyPresenter.class.getSimpleName();

    //weak var output: HomePresenterOutput!
    public WeakReference<CurrencyActivityInput> output;


    @Override
    public void presentCurrencyData(CurrencyResponse response) {
        // Log.e(TAG, "presentCurrencyData() called with: response = [" + response + "]");
        //Do your decoration or filtering here

    }


}
