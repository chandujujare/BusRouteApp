package com.busrouteapp.busroutes.model;

import java.io.Serializable;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class Stops implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
