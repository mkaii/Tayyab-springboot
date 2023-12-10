package be.kdg.programming3.HotelBooking;

import be.kdg.programming3.HotelBooking.repository.DataFactory;
import be.kdg.programming3.HotelBooking.service.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


public class HotelBookingApplication {

	public static void main(String[] args) {

		System.out.println("testing ......");


		//our date setup is done
		DataFactory.seed();

		Scanner sc = new Scanner(System.in);

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

				int choice = sc.nextInt();

				switch (choice) {
					case 0:
						System.out.println("Thank you for using the APP");
						throw new IllegalStateException("Program ended");
					case 1:
						BookingService.showAllRooms();
						break;
					case 2:
						BookingService.showRoomsBasedOnCriteria();
						break;
					case 3:
						BookingService.showAllGuests();
						break;
					case 4:
						BookingService.showGuestsBasedOnCriteria();
						break;
					case 5:
						BookingService.showBookingsBasedOnCriteria();
						break;
					default:
						System.out.println("Invalid entry, try again");
						break;
				}

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
