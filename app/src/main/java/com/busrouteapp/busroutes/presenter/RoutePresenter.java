package com.busrouteapp.busroutes.presenter;

import com.busrouteapp.busroutes.model.Route;
import com.busrouteapp.busroutes.model.RouteImpl;
import com.busrouteapp.busroutes.model.RouteListener;
import com.busrouteapp.busroutes.view.RouteView;

import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class RoutePresenter implements RouteListener{
    private RouteView view;
    private RouteImpl imRoute;
    public RoutePresenter(RouteView view){
        this.view=view;
        imRoute=new RouteImpl(this);
    }

    @Override
    public void showRoutes(List<Route> routes) {
        view.dismissDialog();
        view.showRoutes(routes);
    }

    @Override
    public void onFailed(Throwable e) {
        view.dismissDialog();
        view.showAlertDialog();
    }

    public void getRoutes(){
        view.showDialog();
        imRoute.getRoutes();
    }
}
