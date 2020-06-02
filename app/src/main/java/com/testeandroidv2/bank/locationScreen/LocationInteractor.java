package com.testeandroidv2.bank.locationScreen;

import android.util.Log;

interface LocationInteractorInput {
    public void fetchLocationData(LocationRequest request);
}


public class LocationInteractor implements LocationInteractorInput {

    public static String TAG = LocationInteractor.class.getSimpleName();
    public LocationPresenterInput output;
    public LocationWorkerInput aLocationWorkerInput;

    public LocationWorkerInput getLocationWorkerInput() {
        if (aLocationWorkerInput == null) return new LocationWorker();
        return aLocationWorkerInput;
    }

    public void setLocationWorkerInput(LocationWorkerInput aLocationWorkerInput) {
        this.aLocationWorkerInput = aLocationWorkerInput;
    }

    @Override
    public void fetchLocationData(LocationRequest request) {
        aLocationWorkerInput = getLocationWorkerInput();
        LocationResponse LocationResponse = new LocationResponse();
        // Call the workers

        output.presentLocationData(LocationResponse);
    }
}
