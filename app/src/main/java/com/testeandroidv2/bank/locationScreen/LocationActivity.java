package com.testeandroidv2.bank.locationScreen;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


interface LocationActivityInput {
    public void displayLocationData(LocationViewModel viewModel);
}


public class LocationActivity extends AppCompatActivity
        implements LocationActivityInput {

    public static String TAG = LocationActivity.class.getSimpleName();
    LocationInteractorInput output;
    LocationRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //do the setup

        LocationConfigurator.INSTANCE.configure(this);
        LocationRequest aLocationRequest = new LocationRequest();
        //populate the request


        output.fetchLocationData(aLocationRequest);
        // Do other work
    }


    @Override
    public void displayLocationData(LocationViewModel viewModel) {
        Log.e(TAG, "displayLocationData() called with: viewModel = [" + viewModel + "]");
        // Deal with the data
    }
}
