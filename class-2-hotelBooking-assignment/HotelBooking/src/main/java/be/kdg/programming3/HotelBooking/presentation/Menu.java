package be.kdg.programming3.HotelBooking.presentation;

import be.kdg.programming3.HotelBooking.domain.Guest;
import be.kdg.programming3.HotelBooking.domain.Room;
import be.kdg.programming3.HotelBooking.repository.DataFactory;
import be.kdg.programming3.HotelBooking.repository.JSonWriter;
import be.kdg.programming3.HotelBooking.service.GuestService;
import be.kdg.programming3.HotelBooking.service.GuestServiceImpl;
import be.kdg.programming3.HotelBooking.service.RoomService;
import be.kdg.programming3.HotelBooking.service.RoomServiceImpl;

import java.util.List;
import java.util.Scanner;


public class Menu {

    public static final String PATH = "./src/main/java/be/kdg/programming3/HotelBooking/repository/";

    public void show() {
        Scanner scanner = new Scanner(System.in);
        //get rooms and guests
        List<Room> rooms = DataFactory.getRooms();
        List<Guest> guests = DataFactory.getGuests();

        //create service instance
        RoomService roomService = new RoomServiceImpl(rooms); // Create RoomService instance
        GuestService guestService = new GuestServiceImpl(guests);
        //create presnter instance
        Presenter presenter = new Presenter(roomService,guestService);
        try {
            while (true) {
                System.out.println("What would you like to do ?");
                System.out.println("================================================");
                System.out.println("0) Quit");
                System.out.println("1) Show all rooms");
                System.out.println("2) Show rooms based on Criteria");
                System.out.println("3) Show all the Guests");
                System.out.println("4) Show all guests based on Criteria");
                System.out.println("5) Show booking based on Criteria");

                int choice = scanner.nextInt(); // read input
                switch (choice) {
                    case 0:
                        System.out.println("Thank you for using the APP");
                        throw new IllegalStateException("Program ended");
                    case 1:
                        presenter.showAllRooms(DataFactory.getRooms());
                        JSonWriter.saveToJsonFile(DataFactory.getRooms(), PATH + "room.json");
                        break;
                    case 2:
                        presenter.showRoomsBasedOnCriteria();
                        JSonWriter.saveToJsonFile(DataFactory.getRooms(), PATH + "room.json");
                        break;
                    case 3:
                        presenter.showAllGuests(DataFactory.getGuests());
                        JSonWriter.saveToJsonFile(DataFactory.getGuests(), PATH + "guest.json");
                        break;
                    case 4:
                        presenter.showGuestsBasedOnCriteria(guestService);
                        JSonWriter.saveToJsonFile(DataFactory.getGuests(), PATH + "guest.json");
                        break;
                    case 5:
                        presenter.showBookingsBasedOnCriteria(DataFactory.getRoomBookings());
                        JSonWriter.saveToJsonFile(DataFactory.getRoomBookings(), PATH + "roomBooking.json");
                        break;
                    default:
                        System.out.println("Invalid entry, try again");
                        break;
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            scanner.close(); // clos scanner
        }

    }
}