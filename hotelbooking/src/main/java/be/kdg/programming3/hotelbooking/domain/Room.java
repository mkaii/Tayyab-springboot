package be.kdg.programming3.hotelbooking.domain;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "ROOMS")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    @Column(name = "ROOMNUMBER", nullable = false)
    private String roomNumber;
    @Column(name = "ROOMDESCRIPTION", nullable = false)
    private String roomDescription;
    @Column(name = "FLOOR", nullable = false)
    private Integer floor;
    @Column(name = "PRICE", nullable = false)
    private double price;
    @Column(name = "ROOMTYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @OneToMany(mappedBy = "room")
    List<Reservation> reservation;

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

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}