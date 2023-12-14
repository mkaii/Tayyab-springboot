package be.kdg.programming3.HotelBooking;
import be.kdg.programming3.HotelBooking.presentation.Menu;
import be.kdg.programming3.HotelBooking.repository.DataFactory;

public class HotelBookingApplication {
    public static void main(String[] args) {

        DataFactory.seed();
        Menu menu = new Menu();
        menu.show();
    }
}

