package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Reservation;
import be.kdg.programming3.hotelbooking.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        logger.info("ReservationService instantiated");
    }

    public Reservation getById(final int id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> findByGuestId(int guestId) {
        return reservationRepository.findByGuestId(guestId);
    }

    public List<Reservation> getAll() {
        logger.debug("Fetching all reservations");
        List<Reservation> reservations = reservationRepository.findAll();
        logger.debug("Found {} reservations", reservations.size());
        return reservations;
    }

    public void delete(int reservationId) {
        logger.debug("Deleting reservation with ID: {}", reservationId);
        reservationRepository.deleteById(reservationId);
        logger.debug("Successfully deleted reservation with ID: {}", reservationId);
    }
}
