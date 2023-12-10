package be.kdg.programming3.HotelBooking.model;

public class GuestRoomBooking {

    private Integer guestId;
    private Integer roomBookingId;

    public GuestRoomBooking(Integer guestId, Integer roomBookingId) {
        this.guestId = guestId;
        this.roomBookingId = roomBookingId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getRoomBookingId() {
        return roomBookingId;
    }

    public void setRoomBookingId(Integer roomBookingId) {
        this.roomBookingId = roomBookingId;
    }

    @Override
    public String toString() {
        return "GuestRoomBooking{" +
                "guestId=" + guestId +
                ", roomBookingId=" + roomBookingId +
                '}';
    }
}
