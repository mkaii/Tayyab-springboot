package be.kdg.programming3.HotelBooking.model;

import java.util.List;

public class Room {

    private Integer roomId;
    private String roomNumber;
    private String roomDescription;
    private Integer floor;
    private boolean occupied;
    private double price;
    private RoomType roomType;


    public Room(Integer roomId, String roomNumber, String roomDescription, Integer floor, boolean occupied, double price, RoomType roomType) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
        this.floor = floor;
        this.occupied = occupied;
        this.price = price;
        this.roomType = roomType;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                ", floor=" + floor +
                ", occupied=" + occupied +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
