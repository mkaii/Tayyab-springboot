package be.kdg.programming3.hotelbooking.presentation;

import be.kdg.programming3.hotelbooking.domain.*;
import be.kdg.programming3.hotelbooking.service.BookingService;
import be.kdg.programming3.hotelbooking.service.GuestService;
import be.kdg.programming3.hotelbooking.service.RoomService;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Presenter {
    private final RoomService roomService;
    private final GuestService guestService;
    private final BookingService bookingService;

    public Presenter(RoomService roomService, GuestService guestService, BookingService bookingService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.bookingService = bookingService;
    }

    void showAllRooms() {
        roomService.getAllRooms().forEach(room -> System.out.println(room.toString()));
    }
    public void showRoomsBasedOnCriteria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select room type (1=Single, 2=Double, 3=Deluxe):");
        int choice = scanner.nextInt();

        List<Room> filteredRooms = roomService.getRoomsByChoice(choice);

        if (filteredRooms.isEmpty()) {
            System.out.println("Invalid choice or no rooms found for the selected type.");
        } else {
            System.out.println("Rooms of selected type:");
            filteredRooms.forEach(System.out::println);
        }
    }
    void showAllGuests() {
        guestService.getAllGuests().forEach(room -> System.out.println(room.toString()));
    }
    void showGuestsBasedOnCriteria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender to filter (MALE/FEMALE/OTHER), or leave blank:");
        String genderInput = scanner.nextLine().trim();

        System.out.println("Enter part or full last name to filter guests, or leave blank:");
        String lastNameInput = scanner.nextLine().trim();

        List<Guest> filteredGuests = guestService.getGuestsByInput(genderInput, lastNameInput);

        if (filteredGuests.isEmpty()) {
            System.out.println("No guests found for the selected criteria or invalid input.");
        } else {
            for (Guest guest : filteredGuests) {
                System.out.println(guest);
            }
        }
    }
    void showBookingsBasedOnCriteria() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fromDate = null, toDate = null;
        boolean validDates = false;

        while (!validDates) {
            try {
                System.out.println("Enter the starting date (dd/MM/yyyy):");
                fromDate = LocalDate.parse(scanner.nextLine().trim(), formatter);

                System.out.println("Enter the end date (dd/MM/yyyy):");
                toDate = LocalDate.parse(scanner.nextLine().trim(), formatter);
                validDates = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format, please try again.");
            }
        }

        List<RoomBooking> filteredBookings = bookingService.getBookingsWithinDateRange(fromDate, toDate);

        if (filteredBookings.isEmpty()) {
            System.out.println("No bookings found for these dates.");
        } else {
            System.out.println("Booking Details:");
            filteredBookings.forEach(System.out::println);
        }
    }
}
