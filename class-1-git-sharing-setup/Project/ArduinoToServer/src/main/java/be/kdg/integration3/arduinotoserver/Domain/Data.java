package be.kdg.integration3.arduinotoserver.Domain;

import java.time.LocalDate;

public class Data {
    private LocalDate date;
    private String status;
    private double latitude;
    private String latitudeDirection;
    private double longitude;
    private String longitudeDirection;

    @Override
    public String toString() {
        return "Data{" +
                ", date=" + date +
                ", status=" + status +
                ", latitude=" + latitude +
                ", latitudeDirection=" + latitudeDirection +
                ", longitude=" + longitude +
                ", longitudeDirection=" + longitudeDirection +
                ", heading=" + heading +
                ", magneticDeviation=" + magneticDeviation +
                ", deviationDirection=" + deviationDirection +
                '}';
    }

    private double heading;
    private double magneticDeviation;
    private String deviationDirection;

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

    public Data(LocalDate date, String status, double latitude,
                String latitudeDirection, double longitude, String longitudeDirection,
                double heading, double magneticDeviation, String deviationDirection) {
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
