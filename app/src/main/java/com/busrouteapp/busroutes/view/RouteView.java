package com.busrouteapp.busroutes.view;

import com.busrouteapp.busroutes.model.Route;

import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public interface RouteView {

    void showDialog();

    void dismissDialog();

    void showRoutes(List<Route> list);

    void showAlertDialog();
}
