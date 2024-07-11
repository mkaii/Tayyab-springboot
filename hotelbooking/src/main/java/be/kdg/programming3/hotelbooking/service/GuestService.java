package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;


    public GuestService(final GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAll(){
        return guestRepository.findGuestWithReservations();
    }

    public Guest getById(final int id){return guestRepository.findById(id).orElse(null);}
}

