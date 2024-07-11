package be.kdg.programming3.hotelbooking.domain;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "GUESTS")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guestId;
    @Column(name="GUESTFIRSTNAME", nullable = false)
    private String guestFirstName;
    @Column(name="GUESTLASTNAME", nullable = false)
    private String guestLastName;
    @Column(name="GUESTEMAIL", nullable = false)
    private String guestEmail;
    @Column(name="GUESTCONTACTNUMBER", nullable = false)
    private String guestContactNumber;
    @Column(name="GUESTGENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender guestGender;
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private List<Reservation> reservations;


    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public Gender getGuestGender() {
        return guestGender;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setguestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestContactNumber() {
        return guestContactNumber;
    }

    public void setGuestContactNumber(String guestContactNumber) {
        this.guestContactNumber = guestContactNumber;
    }

    public void setGuestGender(Gender guestGender) {
        this.guestGender = guestGender;
    }

}
