package be.kdg.programming5.HotelManagement.repository;

import be.kdg.programming5.HotelManagement.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest,Integer> {
    @Query("""
        FROM Guest guestAlias
        LEFT JOIN FETCH guestAlias.reservations reservationsWithinGuest
        LEFT JOIN FETCH reservationsWithinGuest.room
        """)
    List<Guest> findGuestsWithReservationsAndRooms();

    @Query("""
        FROM Guest guestAlias
        LEFT JOIN FETCH guestAlias.reservations reservationsWithinGuest
        LEFT JOIN FETCH reservationsWithinGuest.room
        WHERE guestAlias.guestId = :id
        """)
    Optional<Guest> findByIdWithReservationsAndRooms(int id);

    List<Guest> searchGuestsByGuestFirstNameContainingIgnoreCase(String firstName);
}