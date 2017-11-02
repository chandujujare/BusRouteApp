package com.busrouteapp.busroutes.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.busrouteapp.R;
import com.busrouteapp.busroutes.model.Route;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class RouteDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routesdata);
        Route route = (Route) getIntent().getSerializableExtra(getString(R.string.route_data));
        ((TextView) findViewById(R.id.routedetails_name)).setText(route.getName());
        ((TextView) findViewById(R.id.routedetails_description)).setText(route.getDescription());
        (findViewById(R.id.routedetails_accessible)).setVisibility(route.isAccessible() ? View.VISIBLE : View.GONE);
        ImageView logo = (ImageView) findViewById(R.id.routedetails_logo);
        Glide.with(this).load(route.getImage()).into(logo);
        ListView list = (ListView) findViewById(R.id.routedetails_stopslist);
        list.setAdapter(new StopsAdapter(this, route.getStops()));
    }
}
