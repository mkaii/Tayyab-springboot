package be.kdg.programming3.hotelbooking.viewmodel;

import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.domain.RoomType;
import jakarta.validation.constraints.NotBlank;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RoomViewModel {

    private final int roomId;
    @NotBlank(message = "Room Number is mandatory")
    private final String roomNumber;
    @NotBlank(message = "Room Description is mandatory")
    private final String roomDescription;
    private final Integer floor;

    private final double price;

    private final RoomType roomType;

    private final List<AssignedGuest> assignedGuests;

    private RoomViewModel(final Integer roomId, String roomNumber, String roomDescription, Integer floor, double price, RoomType roomType, List<AssignedGuest> assignedGuests) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
        this.floor = floor;
        this.price = price;
        this.roomType = roomType;
        this.assignedGuests = Collections.unmodifiableList(assignedGuests);
    }

    public static RoomViewModel fromDomain(final Room room){
        return new RoomViewModel(
                room.getRoomId(),
                room.getRoomNumber(),
                room.getRoomDescription(),
                room.getFloor(),
                room.getPrice(),
                room.getRoomType(),
                room.getReservation().stream().map(reservation -> new AssignedGuest(
                        reservation.getGuest().getGuestId(),
                        reservation.getGuest().getGuestFirstName()
                )).toList()
        );
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Integer getFloor() {
        return floor;
    }

    public double getPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public List<AssignedGuest> getAssignedGuests() {
        return assignedGuests;
    }
}
