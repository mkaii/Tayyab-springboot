package be.kdg.programming3.hotelbooking.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RoomBooking {

    private Integer roomId;
    private Integer guestId;

    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;


    public RoomBooking(Integer roomId, Integer guestId, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "   Room ID: " + roomId + "\n" +
                "   Guest ID: " + guestId + "\n" +
                "   Booking Start: " + fromDateTime.format(formatter) + "\n" +
                "   Booking End: " + toDateTime.format(formatter) + "\n";
    }
}
