package be.kdg.programming3.hotelbooking.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
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
    private LocalDate check_in_date;
    @Column(name = "CHECK_OUT_DATE")
    private LocalDate check_out_date;
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

    public LocalDate getCheck_in_date() {
        return check_in_date;
    }

    public LocalDate getCheck_out_date() {
        return check_out_date;
    }

    public Integer getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(Integer totalGuests) {
        this.totalGuests = totalGuests;
    }
}
