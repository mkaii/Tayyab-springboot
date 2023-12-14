package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Gender;
import be.kdg.programming3.hotelbooking.domain.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> getGuestsByCriteria(Gender gender, String name);
    List<Guest> getAllGuests();
}
