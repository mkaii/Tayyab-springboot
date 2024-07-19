package be.kdg.programming3.hotelbooking.viewmodel;

import be.kdg.programming3.hotelbooking.domain.Gender;
import be.kdg.programming3.hotelbooking.domain.Guest;
import jakarta.validation.constraints.Email;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GuestViewModel {
    private final int guestId;
    private final String guestFirstName;
    private final String guestLastName;
    @Email(message = "Email is not valid")
    private final String guestEmail;
    private final String guestContactNumber;
    private final Gender guestGender;

    private final List<AssignedRoom> assignedRooms;

    public GuestViewModel(final int guestId, String guestFirstName, String guestLastName, String guestEmail, String guestContactNumber, Gender guestGender, List<AssignedRoom> assignedRooms) {
        this.guestId = guestId;
        this.guestFirstName = guestFirstName;
        this.guestLastName = guestLastName;
        this.guestEmail = guestEmail;
        this.guestContactNumber = guestContactNumber;
        this.guestGender = guestGender;
        this.assignedRooms = Collections.unmodifiableList(assignedRooms);
    }

//    public static GuestViewModel fromDomainWithRooms(final Guest guest) {
//        return new GuestViewModel(
//                guest.getGuestId(),
//                guest.getGuestFirstName(),
//                guest.getGuestLastName(),
//                guest.getGuestEmail(),
//                guest.getGuestContactNumber(),
//                guest.getGuestGender(),
//                guest.getReservations()
//                        .stream()
//                        .map(Reservation::getRoom)
//                        .map(Room::getRoomNumber)
//                        .toList()
//        );
//    }
    public static GuestViewModel fromDomain(final Guest guest){
        return new GuestViewModel(
                guest.getGuestId(),
                guest.getGuestFirstName(),
                guest.getGuestLastName(),
                guest.getGuestEmail(),
                guest.getGuestContactNumber(),
                guest.getGuestGender(),
                guest.getReservations().stream().map(reservation -> new AssignedRoom(
                        reservation.getRoom().getRoomId(),
                        reservation.getRoom().getRoomNumber()
                )).toList()
        );
    }
    public Integer getGuestId() {
        return guestId;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public String getGuestContactNumber() {
        return guestContactNumber;
    }

    public Gender getGuestGender() {
        return guestGender;
    }

    public List<AssignedRoom> getAssignedRooms() {
        return assignedRooms;
    }
}
