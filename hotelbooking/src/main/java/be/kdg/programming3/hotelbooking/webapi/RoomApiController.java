package be.kdg.programming3.hotelbooking.webapi;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.dto.GuestDto;
import be.kdg.programming3.hotelbooking.dto.RoomDto;
import be.kdg.programming3.hotelbooking.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {
    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }


    // api/rooms/{id}reserved
    @GetMapping("{roomId}/reserved")
    public ResponseEntity<List<GuestDto>> getGuestReservedRooms(
            @PathVariable("roomId") int roomId
    ) {
        List<Guest> guests = roomService
                .getAssociatedGuests(roomId);
        if (guests == null) {
            return ResponseEntity.notFound().build();

        }
        List<GuestDto> guestDtos = guests
                .stream()
                .map(GuestDto::fromDomain)
                .toList();
        return ResponseEntity.ok(guestDtos);
    }
}
