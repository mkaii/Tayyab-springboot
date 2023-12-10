package be.kdg.programming3.HotelBooking.model;

import java.time.LocalDateTime;

public class RoomBooking {

    private Integer roomBookingId;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;

    //connection with the actual room
    private Integer roomId;

    public RoomBooking(Integer roomBookingId, LocalDateTime fromDateTime, LocalDateTime toDateTime, Integer roomId) {
        this.roomBookingId = roomBookingId;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.roomId = roomId;
    }

    public Integer getRoomBookingId() {
        return roomBookingId;
    }

    public void setRoomBookingId(Integer roomBookingId) {
        this.roomBookingId = roomBookingId;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomBooking{" +
                "roomBookingId=" + roomBookingId +
                ", fromDateTime=" + fromDateTime +
                ", toDateTime=" + toDateTime +
                ", roomId=" + roomId +
                '}';
    }
}
