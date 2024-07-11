package be.kdg.programming3.hotelbooking.repository;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    @Query("""
    FROM Guest guestAlias
    LEFT JOIN FETCH guestAlias.reservations guestWithReservation
    LEFT JOIN FETCH guestWithReservation.room
    """)
    List<Guest> findGuestWithReservations();
}
