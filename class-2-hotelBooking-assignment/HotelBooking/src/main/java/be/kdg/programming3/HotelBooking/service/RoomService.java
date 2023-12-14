package be.kdg.programming3.HotelBooking.service;

import be.kdg.programming3.HotelBooking.domain.Room;
import be.kdg.programming3.HotelBooking.domain.RoomType;

import java.util.List;

public interface RoomService {
    List<Room> getRoomsByType(RoomType roomType);
}
