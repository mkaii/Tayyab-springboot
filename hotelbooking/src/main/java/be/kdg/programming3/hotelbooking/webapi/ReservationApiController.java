package be.kdg.programming3.hotelbooking.webapi;

import be.kdg.programming3.hotelbooking.dto.ReservationDto;
import be.kdg.programming3.hotelbooking.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {
    private final ReservationService reservationService;
    private static final Logger logger = LoggerFactory.getLogger(ReservationApiController.class);

    public ReservationApiController(ReservationService reservationService) {
        this.reservationService = reservationService;
        logger.info("ReservationApiController instantiated");
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        logger.info("Received request to get all reservations");
        List<ReservationDto> reservations = reservationService
                .getAll()
                .stream()
                .map(ReservationDto::fromDomain)
                .toList();
        logger.info("Returning {} reservations", reservations.size());
        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("reservationId") int reservationId) {
        logger.info("Received request to delete reservation with ID: {}", reservationId);
        reservationService.delete(reservationId);
        logger.info("Successfully deleted reservation with ID: {}", reservationId);
        return ResponseEntity.noContent().build();
    }
}
