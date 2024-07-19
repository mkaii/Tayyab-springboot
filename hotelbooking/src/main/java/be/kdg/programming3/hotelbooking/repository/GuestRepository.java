package be.kdg.programming3.hotelbooking.repository;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    @Query("""
    FROM Guest guestAlias
    LEFT JOIN FETCH guestAlias.reservations guestWithReservation
    LEFT JOIN FETCH guestWithReservation.room
    """)
    List<Guest> findGuestWithReservations();

    @Query("""
    FROM Guest guestAlias
    LEFT JOIN FETCH guestAlias.reservations guestWithReservation
    LEFT JOIN FETCH guestWithReservation.room
    where guestAlias.guestId = :guestId
    """)
    Optional<Guest> findByIdWithReservations(int guestId);

    List<Guest> searchGuestByGuestLastNameContainingIgnoreCase(String guestLastName);


}
