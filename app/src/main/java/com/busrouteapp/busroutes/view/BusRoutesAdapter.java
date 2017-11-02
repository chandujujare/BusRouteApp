package com.busrouteapp.busroutes.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.busrouteapp.R;
import com.busrouteapp.busroutes.model.Route;

import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class BusRoutesAdapter extends BaseAdapter {
    private Context context;
    private List<Route> routeList;

    BusRoutesAdapter(Context context, List<Route> routeList) {
        this.context = context;
        this.routeList = routeList;
    }

    @Override
    public int getCount() {
        return routeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.item_route,null);
        Route route = routeList.get(i);
        ((TextView)view.findViewById(R.id.name)).setText(route.getName());
        ImageView logo=(ImageView) view.findViewById(R.id.logo);
        Glide.with(context).load(route.getImage()).into(logo);
        return view;
    }
}
