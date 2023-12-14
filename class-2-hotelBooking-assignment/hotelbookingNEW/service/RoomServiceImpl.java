package be.kdg.programming3.hotelbooking.service;
import java.util.stream.Collectors;
import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.domain.RoomType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {
    private final List<Room> rooms;

    public RoomServiceImpl(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public List<Room> getRoomsByType(RoomType roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equals(roomType))
                .collect(Collectors.toList());
    }
}
