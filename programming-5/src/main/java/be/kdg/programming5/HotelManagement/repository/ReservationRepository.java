package be.kdg.programming5.HotelManagement.repository;

import be.kdg.programming5.HotelManagement.domain.Reservation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
