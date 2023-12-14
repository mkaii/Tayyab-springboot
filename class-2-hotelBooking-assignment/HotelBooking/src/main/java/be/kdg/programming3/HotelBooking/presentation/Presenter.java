package be.kdg.programming3.HotelBooking.presentation;

import be.kdg.programming3.HotelBooking.domain.*;
import be.kdg.programming3.HotelBooking.service.GuestService;
import be.kdg.programming3.HotelBooking.service.RoomService;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Presenter {
    private final RoomService roomService;
    private final GuestService guestService;

    public Presenter(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    void showAllRooms(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }
    public void showRoomsBasedOnCriteria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select room type (1=Single, 2=Double, 3=Deluxe):");
        int choice = scanner.nextInt();
        RoomType selectedType;
        switch (choice) {
            case 1:
                selectedType = RoomType.SINGLE;
                break;
            case 2:
                selectedType = RoomType.DOUBLE;
                break;
            case 3:
                selectedType = RoomType.DELUXE;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        List<Room> filteredRooms = roomService.getRoomsByType(selectedType);

        if (filteredRooms.isEmpty()) {
            System.out.println("No rooms found for the selected type.");
        } else {
            System.out.println("Rooms of selected type:");
            for (Room room : filteredRooms) {
                System.out.println(room);
            }
        }
    }
    void showAllGuests(List<Guest> guests) {

        for (Guest guest : guests) {
            System.out.println(guest.toString());
        }
    }
    void showGuestsBasedOnCriteria(GuestService guestService) {
        Scanner scanner = new Scanner(System.in);

        // get gender
        System.out.println("Enter gender to filter (MALE/FEMALE/OTHER), or leave blank:");
        String genderInput = scanner.nextLine().trim();
        Gender gender = null;
        if (!genderInput.isEmpty()) {
            try {
                gender = Gender.valueOf(genderInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender entered.");
                return;
            }
        }

        // get name
        System.out.println("Enter part or full second name to filter guests, or leave blank:");
        String filterName = scanner.nextLine().trim().toLowerCase();

        // guestfilterbycritaria
        List<Guest> filteredGuests = guestService.getGuestsByCriteria(gender, filterName.isEmpty() ? null : filterName);

        //print
        if (filteredGuests.isEmpty()) {
            System.out.println("No guests found for the selected criteria.");
        } else {
            for (Guest guest : filteredGuests) {
                System.out.println(guest);
            }
        }
    }
    void showBookingsBasedOnCriteria(List<RoomBooking> bookings) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the starting date (dd/MM/yyyy):");
        LocalDate fromDate;
        try {
            fromDate = LocalDate.parse(scanner.nextLine().trim(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.println("Enter the end date (dd/MM/yyyy):");
        LocalDate toDate;
        try {
            toDate = LocalDate.parse(scanner.nextLine().trim(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.println("Booking Details:");
        boolean foundBooking = false;
        for (RoomBooking booking : bookings) {
            LocalDate bookingFromDate = booking.getFromDateTime().toLocalDate();
            LocalDate bookingToDate = booking.getToDateTime().toLocalDate();

            if (!bookingFromDate.isAfter(toDate) && !bookingToDate.isBefore(fromDate)) {
                System.out.println(booking);
                foundBooking = true;
            }
        }

        if (!foundBooking) {
            System.out.println("No bookings found for these dates.");
        }
    }
}
