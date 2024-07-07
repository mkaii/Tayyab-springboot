package be.kdg.programming5.HotelManagement.controller;
import be.kdg.programming5.HotelManagement.domain.Guest;
import be.kdg.programming5.HotelManagement.domain.Room;
import be.kdg.programming5.HotelManagement.service.GuestService;
import be.kdg.programming5.HotelManagement.service.ReservationService;
import be.kdg.programming5.HotelManagement.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HotelController {
    private final GuestService guestService;
    private final RoomService roomService;
    private final ReservationService reservationService;
    private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
    @Autowired
    public HotelController(RoomService roomService, GuestService guestService, ReservationService reservationService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.reservationService = reservationService;
    }

    @RequestMapping("/")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/rooms")
    public String showRooms(Model model) {
        List<Room> rooms = roomService.getAll();
        model.addAttribute("rooms", rooms);
        LOG.info("All Rooms: {}", rooms);
        return "room-list";
    }


    @RequestMapping("/guests")
    public String showGuests(Model model) {
        List<Guest> guests = guestService.getAll();
        model.addAttribute("guests", guests);
        LOG.info("All Guests: {}", guests);
        return "guest-list";
    }

    @GetMapping("/getGuestsAndReservations")
    public ResponseEntity<Map<String, Object>> ajaxGetGuestsAndReservationsForRoom(@RequestParam("roomId") Integer roomId) {
        Room room = roomService.getById(roomId);
        List<Guest> guests = guestService.findGuestByRoom(room);
        List<Reservation> reservations = reservationService.findByRoom(roomId);
        Map<String, Object> response = new HashMap<>();
        response.put("guests", guests);
        response.put("reservations", reservations);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/deleteRoom")
    public ResponseEntity<?> deleteRoom(@RequestParam("roomId") int roomId) {
        try {
            roomService.delete(roomId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/getRoomsForGuests")
    public ResponseEntity<Map<String, Object>> ajaxGetRoomsAndReservationsByGuest(@RequestParam("guestId") Integer guestId) {
        Guest guest = guestService.getById(guestId);
        List<Room> rooms = guest.getRooms();
        System.out.println("Rooms: " + rooms);
        Map<String, Object> response = new HashMap<>();
        response.put("rooms", rooms);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/deleteGuest")
    public ResponseEntity<?> deleteGuest(@RequestParam("guestId") int guestId) {
        try {
            guestService.delete(guestId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
