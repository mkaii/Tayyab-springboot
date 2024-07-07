package be.kdg.programming5.HotelManagement.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import be.kdg.programming5.HotelManagement.domain.Gender;

@Entity
@Table(name = "Guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestId")
    private Integer guestId;

    @Column(name = "guestFirstName", nullable = false)
    private String guestFirstName;

    @Column(name = "guestLastName", nullable = false)
    private String guestLastName;

    @Column(name = "guestEmail", nullable = false)
    private String guestEmail;

    @Column(name = "guestContactNumber", nullable = false)
    private String guestContactNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "guestGender", nullable = false)
    private Gender guestGender;

    @Column(name = "dateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
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

    public Gender getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(Gender guestGender) {
        this.guestGender = guestGender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
