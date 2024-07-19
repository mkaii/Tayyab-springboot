package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Reservation;
import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(final RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public List<Room> getAll(){return roomRepository.findAll();
    }
    public Room getById(final int id){
        return roomRepository.findById(id).orElse(null);
    }
    public List<Guest> getAssociatedGuests(int roomId){
        final Room room = roomRepository.findById(roomId).orElse(null);
        if (room == null) {
            return null;
        }//get the left side from many to many relation(guest)

        final List<Guest> result = new ArrayList<>(); //create intermediate variable called "result"

        for(final Reservation reservation : room.getReservations()){
            result.add(reservation.getGuest());
        }//get the right side from many to many relation (room)
        return result;
    }

}


