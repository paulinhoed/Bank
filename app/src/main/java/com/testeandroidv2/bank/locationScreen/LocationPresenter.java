package com.testeandroidv2.bank.locationScreen;

import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

interface LocationPresenterInput {
    public void presentLocationData(LocationResponse response);
}


public class LocationPresenter implements LocationPresenterInput {

    public static String TAG = LocationPresenter.class.getSimpleName();

    //weak var output: HomePresenterOutput!
    public WeakReference<LocationActivityInput> output;


    @Override
    public void presentLocationData(LocationResponse response) {
        // Log.e(TAG, "presentLocationData() called with: response = [" + response + "]");
        //Do your decoration or filtering here

    }


}
