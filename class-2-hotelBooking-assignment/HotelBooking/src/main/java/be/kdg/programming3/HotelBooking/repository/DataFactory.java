package be.kdg.programming3.HotelBooking.repository;

import be.kdg.programming3.HotelBooking.model.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    //these 4 lists are our actual source of data
    private static List<Room> rooms = new ArrayList<>();
    private static List<RoomPhoto> roomPhotos = new ArrayList<>();
    private static List<RoomBooking> roomBookings = new ArrayList<>();
    private static List<Guest> guests = new ArrayList<>();


    //create the initial mock data with which the client can interact using the console
    public static void seed()
    {
        //create rooms in the system :

        Room room1 = new Room(1, "101","Single Bed Room",   1, false, 1000.0, RoomType.SINGLE);
        Room room2 = new Room(2, "201","Double Bed Room",   2, false, 2000.0, RoomType.DOUBLE);
        Room room3 = new Room(3, "301","Deluxe Bed Room",   3, false, 3000.0, RoomType.DELUXE);
        Room room4 = new Room(4, "401","Single Bed Room",   4, false, 1500.0, RoomType.SINGLE);

        /*rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);*/

        rooms.addAll(List.of(room1,room2,room3,room4));

        //create the room photo
        //room 1 photo :

        RoomPhoto room1photo1 = new RoomPhoto(1,"link-1",1);
        RoomPhoto room1photo2 = new RoomPhoto(2,"link-2",1);

        RoomPhoto room2photo1 = new RoomPhoto(3,"link-3",2);

        roomPhotos.addAll(List.of(room1photo1,room1photo2,room2photo1));



        // creating the guests mock data

        Guest guest1 = new Guest(1, "John", "Doe", "john.doe@gmail.com", "+1234567890",Gender.MALE);
        Guest guest2 = new Guest(2, "Jane", "Smith", "jane.smith@yahoo.com", "+9876543210",Gender.MALE);
        Guest guest3 = new Guest(3, "Alice", "Johnson", "alice.johnson@hotmail.com", "+1112223333",Gender.FEMALE);
        Guest guest4 = new Guest(4, "Bob", "Williams", "bob.williams@gmail.com", "+5556667777",Gender.MALE);
        Guest guest5 = new Guest(5, "Eva", "Brown", "eva.brown@example.com", "+9998887777",Gender.FEMALE);


        guests.addAll(List.of(guest1,guest2,guest3,guest4,guest5));

        //make roomBookings in the system using the rooms that we have : ensure that the data allows many to many mapping in the end.
        //roomBookings pov m to 1
        //room pov 1-m

        //create bookings

        //booking 1
        LocalDateTime booking1StartTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 10, 0);
        LocalDateTime booking1EndTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 11, 0);

        RoomBooking booking1 = new RoomBooking(1,2,booking1StartTime,booking1EndTime);


        //booking 2
        LocalDateTime booking2StartTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 11, 0);
        LocalDateTime booking2EndTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 12, 0);

        RoomBooking booking2 = new RoomBooking(1,3,booking2StartTime,booking2EndTime);


        //booking 3
        LocalDateTime booking3StartTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 11, 0);
        LocalDateTime booking3EndTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 12, 0);

        RoomBooking booking3 = new RoomBooking(3,2,booking2StartTime,booking2EndTime);

        //booking 4
        LocalDateTime booking4StartTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 11, 0);
        LocalDateTime booking4EndTime = LocalDateTime.of(2023, Month.DECEMBER, 9, 12, 0);

        RoomBooking booking4 = new RoomBooking(4,3,booking2StartTime,booking2EndTime);

        //add the above 3 bookings in the bookings list

        roomBookings.addAll(List.of(booking1,booking2,booking3,booking4));


    }


    public static List<Room> getRooms() {
        return rooms;
    }

    public static void setRooms(List<Room> rooms) {
        DataFactory.rooms = rooms;
    }

    public static List<RoomPhoto> getRoomPhotos() {
        return roomPhotos;
    }

    public static void setRoomPhotos(List<RoomPhoto> roomPhotos) {
        DataFactory.roomPhotos = roomPhotos;
    }

    public static List<RoomBooking> getRoomBookings() {
        return roomBookings;
    }

    public static void setRoomBookings(List<RoomBooking> roomBookings) {
        DataFactory.roomBookings = roomBookings;
    }

    public static List<Guest> getGuests() {
        return guests;
    }

    public static void setGuests(List<Guest> guests) {
        DataFactory.guests = guests;
    }
}
