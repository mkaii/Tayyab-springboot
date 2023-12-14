package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.Gender;
import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.repository.DataFactory;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GuestServiceImpl implements GuestService {

    List<Guest> guests = new ArrayList<>(DataFactory.getGuests());

    public GuestServiceImpl() {

    }

    @Override
    public List<Guest> getGuestsByCriteria(Gender gender, String name) {
        return guests.stream()
                .filter(guest -> (gender == null || guest.getGuestGender() == gender) &&
                        (name == null || guest.getGuestLastName().toLowerCase().contains(name.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Guest> getAllGuests() {
        return guests;
    }

    @Override
    public List<Guest> getGuestsByInput(String genderInput, String name) {
        Gender gender = null;
        if (!genderInput.isEmpty()) {
            try {
                gender = Gender.valueOf(genderInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                return Collections.emptyList(); // Return empty list if gender is invalid
            }
        }
        String filterName = name.isEmpty() ? null : name.toLowerCase();
        return getGuestsByCriteria(gender, filterName);
    }

}

