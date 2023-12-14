package be.kdg.programming3.hotelbooking.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.domain.RoomType;
import be.kdg.programming3.hotelbooking.repository.DataFactory;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    List<Room>rooms=new ArrayList<>(DataFactory.getRooms());
    public RoomServiceImpl() {

    }
    @Override
    public List<Room> getRoomsByType(RoomType roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType() == roomType)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public List<Room> getRoomsByChoice(int choice) {
        RoomType selectedType;
        switch (choice) {
            case 1: selectedType = RoomType.SINGLE; break;
            case 2: selectedType = RoomType.DOUBLE; break;
            case 3: selectedType = RoomType.DELUXE; break;
            default: return Collections.emptyList();
        }
        return getRoomsByType(selectedType);
    }
}
