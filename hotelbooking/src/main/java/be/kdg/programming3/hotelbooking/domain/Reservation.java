package be.kdg.programming3.hotelbooking.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "RESERVATIONS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"guestId", "roomId"})
        }
)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "roomId")
    private Room room;
    @ManyToOne(optional = false)
    @JoinColumn(name = "guestId")
    private Guest guest;
    @Column(name = "CHECK_IN_DATE")
    private LocalDateTime check_in_date;
    @Column(name = "CHECK_OUT_DATE")
    private LocalDateTime check_out_date;
    @Column(name = "TOTALGUEST")
    private Integer totalGuests;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDateTime getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(LocalDateTime check_in_date) {
        this.check_in_date = check_in_date;
    }

    public LocalDateTime getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(LocalDateTime check_out_date) {
        this.check_out_date = check_out_date;
    }

    public Integer getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(Integer totalGuests) {
        this.totalGuests = totalGuests;
    }
}
