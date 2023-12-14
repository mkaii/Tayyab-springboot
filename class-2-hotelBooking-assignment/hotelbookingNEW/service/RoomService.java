package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.domain.RoomType;

import java.util.List;

public interface RoomService {
    List<Room> getRoomsByType(RoomType roomType);
}
