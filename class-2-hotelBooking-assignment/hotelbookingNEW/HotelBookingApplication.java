package be.kdg.programming3.hotelbooking;
import be.kdg.programming3.hotelbooking.presentation.Menu;
import be.kdg.programming3.hotelbooking.repository.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
@SpringBootApplication
public class HotelBookingApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(HotelBookingApplication.class, args);
		DataFactory.seed();
		Menu menu = context.getBean(Menu.class);
		menu.show();
	}
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}


}
