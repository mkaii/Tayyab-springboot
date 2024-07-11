package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

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
}


