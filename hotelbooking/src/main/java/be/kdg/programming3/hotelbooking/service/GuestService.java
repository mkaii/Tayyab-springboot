package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Reservation;
import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.repository.GuestRepository;
import be.kdg.programming3.hotelbooking.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;


    public GuestService(final GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Guest> getAll(){
        return guestRepository.findGuestWithReservations();
    }

    public Guest getById(final int id){return guestRepository.findById(id).orElse(null);}


    public List<Guest> search(String searchTerm){
        return guestRepository.searchGuestByGuestLastNameContainingIgnoreCase(searchTerm);
    }
    public List<Room> getReservedRooms(int guestId){
        final Guest guest = guestRepository.findById(guestId).orElse(null);
        if (guest == null) {
            return null;
        }//get the left side from many to many relation(guest)

        final List<Room> result = new ArrayList<>(); //create intermediate variable called "result"

        for(final Reservation reservation : guest.getReservations()){
            result.add(reservation.getRoom());
        }//get the right side from many to many relation (room)
        return result;
    }

}

