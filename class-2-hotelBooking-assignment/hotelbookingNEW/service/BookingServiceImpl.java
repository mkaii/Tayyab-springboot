package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.RoomBooking;
import be.kdg.programming3.hotelbooking.repository.DataFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService{
List<RoomBooking>roomBookings=new ArrayList<>(DataFactory.getRoomBookings());
    @Override
    public List<RoomBooking> getBookingsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return roomBookings.stream()
                .filter(booking -> !booking.getFromDateTime().toLocalDate().isAfter(endDate) &&
                        !booking.getToDateTime().toLocalDate().isBefore(startDate))
                .collect(Collectors.toList());
    }
}
