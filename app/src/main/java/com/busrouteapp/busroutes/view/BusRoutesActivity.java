package com.busrouteapp.busroutes.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.busrouteapp.R;
import com.busrouteapp.Utils;
import com.busrouteapp.busroutes.model.Route;
import com.busrouteapp.busroutes.presenter.RoutePresenter;

import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class BusRoutesActivity extends Activity implements RouteView, AdapterView.OnItemClickListener {

    private ProgressDialog dialog;
    private ListView mRoutesView;
    private List<Route> routeList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        mRoutesView = (ListView) findViewById(R.id.routes_list);
        mRoutesView.setOnItemClickListener(this);
        RoutePresenter presenter = new RoutePresenter(this);
        if (Utils.isNetworkAvailable(this)) {
            presenter.getRoutes();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyle);
            builder.setTitle(R.string.app_name);
            builder.setMessage(R.string.network);
            builder.setPositiveButton(R.string.ok, null);
            builder.show();
        }
    }

    @Override
    public void showDialog() {
        dialog = ProgressDialog.show(this, null, "Please Wait");
        dialog.show();

    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }

    @Override
    public void showRoutes(List<Route> list) {
        routeList = list;
        BusRoutesAdapter adapter = new BusRoutesAdapter(this, routeList);
        mRoutesView.setAdapter(adapter);

    }

    @Override
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyle);
        builder.setTitle(R.string.app_name);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.ok, null);
        builder.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, RouteDetailsActivity.class);
        intent.putExtra(getString(R.string.route_data), routeList.get(i));
        startActivity(intent);
    }
}
