package be.kdg.programming5.HotelManagement.service;

import be.kdg.programming5.HotelManagement.domain.Guest;
import be.kdg.programming5.HotelManagement.domain.Reservation;
import be.kdg.programming5.HotelManagement.domain.Room;
import be.kdg.programming5.HotelManagement.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAll() {
        return guestRepository.findGuestsWithReservationsAndRooms();
    }

    public Guest getById(int id) {
        return guestRepository.findByIdWithReservationsAndRooms(id).orElse(null);
    }

    public void delete(int id) {
        // Step 1: Retrieve the guest that we're trying to delete
        final Guest guest = guestRepository.findById(id).orElseThrow();
        // Step 2: Delete the guest itself
        guestRepository.deleteById(id);
    }

    public List<Guest> search(String searchTerm) {
        return guestRepository.searchGuestsByGuestFirstNameContainingIgnoreCase(searchTerm);
    }

    public List<Room> getBookedRooms(int guestId) {
        // Step 1: Retrieve the left side from the ManyToMany (guest)
        final Guest guest = guestRepository.findById(guestId).orElse(null);
        if (guest == null) {
            return null;
        }

        // Step 2: Create result intermediate variable
        final List<Room> result = new ArrayList<>();

        // Step 3: Traverse the middle in the ManyToMany (reservation)
        for (final Reservation reservation : guest.getReservations()) {
            // Step 4: Extract the right side from the ManyToMany (room)
            result.add(reservation.getRoom());
        }

        return result;
    }
}
