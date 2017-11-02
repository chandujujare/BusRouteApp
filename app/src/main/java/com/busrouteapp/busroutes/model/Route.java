package com.busrouteapp.busroutes.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class Route implements Serializable{

    Integer id;
    String name;
    List<Stops> stops;
    String description;
    boolean accessible;
    String image;

    public List<Stops> getStops() {
        return stops;
    }

    public void setStops(List<Stops> stops) {
        this.stops = stops;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
