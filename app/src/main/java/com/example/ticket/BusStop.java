package com.example.ticket;

public class BusStop {
    private String busNumber;
    private String stopNumber;
    private String stopName;
    private String routeId;

    // Default constructor (required for Firebase)
    public BusStop() {
        // Default constructor required for calls to DataSnapshot.getValue(BusStop.class)
    }

    public BusStop(String busNumber, String stopNumber, String stopName, String routeId) {
        this.busNumber = busNumber;
        this.stopNumber = stopNumber;
        this.stopName = stopName;
        this.routeId = routeId;
    }

    // Getters and setters
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(String stopNumber) {
        this.stopNumber = stopNumber;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}

