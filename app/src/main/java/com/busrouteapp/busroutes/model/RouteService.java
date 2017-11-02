package com.busrouteapp.busroutes.model;

import com.busrouteapp.Config;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public interface RouteService {

    @GET(Config.ROUTES)
    Single<Routes> getRoutes();
}
