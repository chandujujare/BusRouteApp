package com.busrouteapp.busroutes.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.busrouteapp.R;
import com.busrouteapp.busroutes.model.Stops;

import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class StopsAdapter extends BaseAdapter {
    Context context;
    List<Stops> stops;

    public StopsAdapter(Context context, List<Stops> stops) {
        this.context = context;
        this.stops = stops;
    }

    @Override
    public int getCount() {
        return stops.size();
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

        view = LayoutInflater.from(context).inflate(R.layout.item_stop, null);
        ((TextView) view.findViewById(R.id.name)).setText(stops.get(i).getName());
        View viewById = view.findViewById(R.id.view);
        if (i == stops.size()-1) {
            viewById.setVisibility(View.GONE);
        } else {
            viewById.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
