package com.busrouteapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class Utils {
    public static final int WIFI = 1;
    public static final int MOBILE = 2;
    public static final int NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return MOBILE;
        }
        return NOT_CONNECTED;
    }



    public static boolean isNetworkAvailable(Context context) {
        return getConnectivityStatus(context) > NOT_CONNECTED;
    }

}
