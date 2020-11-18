package com.abis_creations.android.railfarecanculator.models;

public class Station {


    int stationId;
    String stationName;
    int stationLogo;

    float distanceBetweenStations;
    int noOfStops;

    public Station() {
    }


    public Station(int stationId, String stationName, int stationLogo, float distanceBetweenStations, int noOfStops) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationLogo = stationLogo;
        this.distanceBetweenStations = distanceBetweenStations;
        this.noOfStops = noOfStops;
    }

    public int getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public int getStationLogo() {
        return stationLogo;
    }

    public float getDistanceBetweenStations() {
        return distanceBetweenStations;
    }

    public int getNoOfStops() {
        return noOfStops;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setStationLogo(int stationLogo) {
        this.stationLogo = stationLogo;
    }

    public void setDistanceBetweenStations(float distanceBetweenStations) {
        this.distanceBetweenStations = distanceBetweenStations;
    }

    public void setNoOfStops(int noOfStops) {
        this.noOfStops = noOfStops;
    }
}
