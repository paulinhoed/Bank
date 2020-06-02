package com.testeandroidv2.bank.locationScreen;

import java.lang.ref.WeakReference;


public enum LocationConfigurator {
    INSTANCE;

    public void configure(LocationActivity activity) {

        LocationRouter router = new LocationRouter();
        router.activity = new WeakReference<>(activity);

        LocationPresenter presenter = new LocationPresenter();
        presenter.output = new WeakReference<LocationActivityInput>(activity);

        LocationInteractor interactor = new LocationInteractor();
        interactor.output = presenter;

        if (activity.output == null) {
            activity.output = interactor;
        }
        if (activity.router == null) {
            activity.router = router;
        }
    }
}
