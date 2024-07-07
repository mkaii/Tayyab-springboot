package be.kdg.programming5.HotelManagement.service;

import be.kdg.programming5.HotelManagement.domain.Room;
import be.kdg.programming5.HotelManagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void delete(int id) {
        roomRepository.deleteById(id);
    }
}
