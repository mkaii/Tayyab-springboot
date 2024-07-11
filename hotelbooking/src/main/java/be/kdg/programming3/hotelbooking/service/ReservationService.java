//package be.kdg.programming3.hotelbooking.service;
//
//import be.kdg.programming3.hotelbooking.domain.Reservation;
//import be.kdg.programming3.hotelbooking.repository.DataFactory;
//import be.kdg.programming3.hotelbooking.repository.JSonWriter;
//import be.kdg.programming3.hotelbooking.repository.ReservationJDBCTemplateRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//@Profile("collections")
//@Service
//public class ReservationService {
//List<Reservation> reservations =new ArrayList<>(DataFactory.getRoomBookings());
//private final ReservationJDBCTemplateRepository reservationJDBCTemplateRepository;
//    public static final String PATH = "./src/main/java/be/kdg/programming3/HotelBooking/repository/";
//
//    public ReservationService(List<Reservation> reservations, ReservationJDBCTemplateRepository reservationJDBCTemplateRepository) {
//        this.reservations = reservations;
//        this.reservationJDBCTemplateRepository = reservationJDBCTemplateRepository;
//    }
//
//    @Override
//    public List<Reservation> getBookingsWithinDateRange(LocalDate startDate, LocalDate endDate) {
//        return reservations.stream()
//                .filter(booking -> !booking.getCheck_in_date().toLocalDate().isAfter(endDate) &&
//                        !booking.getCheck_out_date().toLocalDate().isBefore(startDate))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void writeRoomBookingsToJson(List<Reservation> reservations) {
//        JSonWriter.saveToJsonFile(reservations, PATH + "room.json");
//    }
//
//    @Override
//    public List<Reservation> findAll() {
//        return reservationJDBCTemplateRepository.findAll();
//    }
//
//
//    @Override
//    public Reservation findById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Reservation> findByRoom(int roomId) {
//        return null;
//    }
//
//    @Override
//    public List<Reservation> findByGuest(int guestId) {
//        return null;
//    }
//
//    @Override
//    public Reservation createReservation(Reservation reservation) {
//        return null;
//    }
//
//    @Override
//    public void updateReservation(Reservation reservation) {
//
//    }
//
//    @Override
//    public void deleteReservation(int reservationId) {
//
//    }
//
//    @Override
//    public void loadGuest(Reservation reservation) {
//
//    }
//
//    @Override
//    public void loadRoom(Reservation reservation) {
//
//    }
//
//}
