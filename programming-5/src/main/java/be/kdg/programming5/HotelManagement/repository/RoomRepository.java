package be.kdg.programming5.HotelManagement.repository;

import be.kdg.programming5.HotelManagement.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
