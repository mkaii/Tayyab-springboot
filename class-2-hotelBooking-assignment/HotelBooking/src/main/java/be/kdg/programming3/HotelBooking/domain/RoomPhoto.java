package be.kdg.programming3.HotelBooking.domain;

public class RoomPhoto {

    private Integer roomPhotoId;
    private String roomPhotoLink;

    private Integer roomId;

    public RoomPhoto(Integer roomPhotoId, String roomPhotoLink, Integer roomId) {
        this.roomPhotoId = roomPhotoId;
        this.roomPhotoLink = roomPhotoLink;
        this.roomId = roomId;
    }

    public Integer getRoomPhotoId() {
        return roomPhotoId;
    }

    public void setRoomPhotoId(Integer roomPhotoId) {
        this.roomPhotoId = roomPhotoId;
    }

    public String getRoomPhotoLink() {
        return roomPhotoLink;
    }

    public void setRoomPhotoLink(String roomPhotoLink) {
        this.roomPhotoLink = roomPhotoLink;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomPhoto{" +
                "roomPhotoId=" + roomPhotoId +
                ", roomPhotoLink='" + roomPhotoLink + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
