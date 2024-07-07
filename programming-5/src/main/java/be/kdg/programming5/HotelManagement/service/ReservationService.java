package be.kdg.programming5.HotelManagement.service;

import be.kdg.programming5.HotelManagement.domain.Reservation;
import be.kdg.programming5.HotelManagement.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void delete(int id) {
        reservationRepository.deleteById(id);
    }
}
