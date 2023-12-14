package be.kdg.programming3.HotelBooking.service;
import java.util.stream.Collectors;
import be.kdg.programming3.HotelBooking.domain.Room;
import be.kdg.programming3.HotelBooking.domain.RoomType;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private final List<Room> rooms;

    public RoomServiceImpl(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public List<Room> getRoomsByType(RoomType roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType() == roomType)
                .collect(Collectors.toList());
    }
}
