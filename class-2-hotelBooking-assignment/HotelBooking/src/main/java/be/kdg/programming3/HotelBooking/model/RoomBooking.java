package be.kdg.programming3.HotelBooking.model;

import java.time.LocalDateTime;

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
        return "RoomBooking{" +
                "roomId=" + roomId +
                ", guestId=" + guestId +
                ", fromDateTime=" + fromDateTime +
                ", toDateTime=" + toDateTime +
                '}';
    }
}
