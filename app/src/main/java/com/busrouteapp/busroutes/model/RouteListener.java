package com.busrouteapp.busroutes.model;

import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public interface RouteListener {
    void showRoutes(List<Route> routes);

    void onFailed(Throwable e);
}
