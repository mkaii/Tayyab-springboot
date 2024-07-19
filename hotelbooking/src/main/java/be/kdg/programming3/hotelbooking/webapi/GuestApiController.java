package be.kdg.programming3.hotelbooking.webapi;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.dto.GuestDto;
import be.kdg.programming3.hotelbooking.dto.ReservationDto;
import be.kdg.programming3.hotelbooking.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {
    private final GuestService guestService;

    public GuestApiController(GuestService guestService) {
        this.guestService = guestService;
    }

    // /api/guests?searchTerm=X
    @GetMapping
    public ResponseEntity<List<GuestDto>> getGuests(@RequestParam("searchTerm") String searchTerm) {
        List<GuestDto> guestDtos = guestService
                .search(searchTerm)
                .stream()
                .map(GuestDto::fromDomain)
                .toList();
        return ResponseEntity.ok(guestDtos);
    }

    // /api/guests/{guestId}
    @GetMapping("/{guestId}")
    public ResponseEntity<GuestDto> getGuestById(@PathVariable("guestId") int guestId) {
        Guest guest = guestService.getById(guestId);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GuestDto.fromDomain(guest));
    }


    // /api/guests/{guestId}/reservations
    @GetMapping("/{guestId}/reservations")
    public ResponseEntity<List<ReservationDto>> getGuestReservations(@PathVariable("guestId") int guestId) {
        Guest guest = guestService.getById(guestId);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        List<ReservationDto> reservationDtos = guest.getReservations()
                .stream()
                .map(ReservationDto::fromDomain)
                .toList();
        return ResponseEntity.ok(reservationDtos);
    }


}
