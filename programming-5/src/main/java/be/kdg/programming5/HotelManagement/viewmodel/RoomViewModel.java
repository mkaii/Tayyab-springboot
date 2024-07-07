package be.kdg.programming5.HotelManagement.viewmodel;

import be.kdg.programming5.HotelManagement.domain.Room;
import be.kdg.programming5.HotelManagement.domain.RoomType;

public class RoomViewModel {
    private final int id;
    private final int number;
    private final String description;
    private final int floor;
    private final double price;
    private final RoomType roomType;


    private RoomViewModel(final int id, final int number, final String description,final int floor,final double price,final RoomType roomType) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.floor = floor;
        this.price = price;
        this.roomType = roomType;
    }
    public static RoomViewModel fromDomain(final Room room) {
        return new RoomViewModel(
                room.getRoomId(),
                room.getRoomNumber(),
                room.getRoomDescription(),
                room.getFloor(),
                room.getPrice(),
                room.getRoomType()
        );
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public int getFloor() {
        return floor;
    }

    public double getPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
