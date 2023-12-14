package be.kdg.programming3.hotelbooking;
import be.kdg.programming3.hotelbooking.presentation.Menu;
import be.kdg.programming3.hotelbooking.repository.DataFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
		DataFactory.seed();
		Menu menu = new Menu();
		menu.show();
	}

}
