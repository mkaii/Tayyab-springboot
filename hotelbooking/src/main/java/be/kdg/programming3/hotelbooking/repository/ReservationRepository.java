package be.kdg.programming3.hotelbooking.repository;

import be.kdg.programming3.hotelbooking.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.guest.guestId = :guestId")
    List<Reservation> findByGuestId(@Param("guestId") int guestId);
}
