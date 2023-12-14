package be.kdg.programming3.hotelbooking.service;

import be.kdg.programming3.hotelbooking.domain.RoomBooking;
import be.kdg.programming3.hotelbooking.repository.DataFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface BookingService {
    List<RoomBooking> getBookingsWithinDateRange(LocalDate startDate, LocalDate endDate);
}
