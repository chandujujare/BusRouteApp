package com.busrouteapp;

import android.app.Application;

import com.busrouteapp.busroutes.model.RestClient;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class BusRouteApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        RestClient.configure(getString(R.string.base_url));
    }
}
