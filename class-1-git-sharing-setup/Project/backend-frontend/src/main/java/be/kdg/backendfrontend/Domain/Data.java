package be.kdg.backendfrontend.Domain;

import java.time.LocalDate;

public class Data {
    private int deviceID;
    private int dataID;
    private LocalDate date;
    private String status;
    private double latitude;
    private String latitudeDirection;
    private double longitude;
    private String longitudeDirection;

    @Override
    public String toString() {
        return "Data{" +
                "\n  deviceID=" + deviceID +
                ",\n  dataID=" + dataID +
                ",\n  date=" + date +
                ",\n  status=" + status +
                ",\n  latitude=" + latitude +
                ",\n  latitudeDirection=" + latitudeDirection +
                ",\n  longitude=" + longitude +
                ",\n  longitudeDirection=" + longitudeDirection +
                ",\n  heading=" + heading +
                ",\n  magneticDeviation=" + magneticDeviation +
                ",\n  deviationDirection=" + deviationDirection +
                "\n}";
    }

    private double heading;
    private double magneticDeviation;
    private String deviationDirection;

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public double getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLatitudeDirection() {
        return latitudeDirection;
    }

    public void setLatitudeDirection(String latitudeDirection) {
        this.latitudeDirection = latitudeDirection;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLongitudeDirection() {
        return longitudeDirection;
    }

    public void setLongitudeDirection(String longitudeDirection) {
        this.longitudeDirection = longitudeDirection;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getMagneticDeviation() {
        return magneticDeviation;
    }

    public void setMagneticDeviation(double magneticDeviation) {
        this.magneticDeviation = magneticDeviation;
    }

    public String getDeviationDirection() {
        return deviationDirection;
    }

    public void setDeviationDirection(String deviationDirection) {
        this.deviationDirection = deviationDirection;
    }

    public Data(int deviceID, int dataID, LocalDate date, String status, double latitude,
                String latitudeDirection, double longitude, String longitudeDirection,
                double heading, double magneticDeviation, String deviationDirection) {
        this.deviceID = deviceID;
        this.dataID = dataID;
        this.date = date;
        this.status = status;
        this.latitude = latitude;
        this.latitudeDirection = latitudeDirection;
        this.longitude = longitude;
        this.longitudeDirection = longitudeDirection;
        this.heading = heading;
        this.magneticDeviation = magneticDeviation;
        this.deviationDirection = deviationDirection;
    }

    public Data(int deviceID, LocalDate date, String status, double latitude,
                String latitudeDirection, double longitude, String longitudeDirection,
                double heading, double magneticDeviation, String deviationDirection) {
        this.deviceID = deviceID;
        this.date = date;
        this.status = status;
        this.latitude = latitude;
        this.latitudeDirection = latitudeDirection;
        this.longitude = longitude;
        this.longitudeDirection = longitudeDirection;
        this.heading = heading;
        this.magneticDeviation = magneticDeviation;
        this.deviationDirection = deviationDirection;
    }
}
