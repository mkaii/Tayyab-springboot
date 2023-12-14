package be.kdg.programming3.HotelBooking.service;

import be.kdg.programming3.HotelBooking.domain.Gender;
import be.kdg.programming3.HotelBooking.domain.Guest;
import be.kdg.programming3.HotelBooking.domain.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestServiceImpl implements GuestService {
    private final List<Guest> guests;

    public GuestServiceImpl(List<Guest> guests) {
        this.guests = guests;
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
        return new ArrayList<>(guests);
    }


}

