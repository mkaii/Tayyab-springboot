package be.kdg.programming3.hotelbooking.presentation;
import be.kdg.programming3.hotelbooking.repository.DataFactory;
import be.kdg.programming3.hotelbooking.repository.JSonWriter;
import be.kdg.programming3.hotelbooking.service.*;

import java.util.Scanner;


public class Menu {

    public static final String PATH = "./src/main/java/be/kdg/programming3/HotelBooking/repository/";

    public void show() {
        Scanner scanner = new Scanner(System.in);

        //create service instance
        RoomService roomService = new RoomServiceImpl(); // Create RoomService instance
        GuestService guestService = new GuestServiceImpl();
        BookingService bookingService = new BookingServiceImpl();
        //create presnter instance
        Presenter presenter = new Presenter(roomService,guestService, bookingService);
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
                        presenter.showAllRooms();
                        JSonWriter.saveToJsonFile(DataFactory.getRooms(), PATH + "room.json");
                        break;
                    case 2:
                        presenter.showRoomsBasedOnCriteria();
                        JSonWriter.saveToJsonFile(DataFactory.getRooms(), PATH + "room.json");
                        break;
                    case 3:
                        presenter.showAllGuests();
                        JSonWriter.saveToJsonFile(DataFactory.getGuests(), PATH + "guest.json");
                        break;
                    case 4:
                        presenter.showGuestsBasedOnCriteria();
                        JSonWriter.saveToJsonFile(DataFactory.getGuests(), PATH + "guest.json");
                        break;
                    case 5:
                        presenter.showBookingsBasedOnCriteria();
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