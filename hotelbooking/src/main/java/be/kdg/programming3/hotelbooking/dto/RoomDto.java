package be.kdg.programming3.hotelbooking.dto;

import be.kdg.programming3.hotelbooking.domain.Room;

public record RoomDto(
        int roomId,
        String roomNumber

) {

    //converting a domain entity into a web Dto

    public static RoomDto fromDomain (Room room){
        return new RoomDto(
                room.getRoomId(),
                room.getRoomNumber()
        );
    }
}
