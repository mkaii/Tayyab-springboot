package be.kdg.programming3.hotelbooking.dto;

import be.kdg.programming3.hotelbooking.domain.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReservationDto(
        int reservationId,
        GuestDto guest,
        RoomDto room,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {
    public static ReservationDto fromDomain(Reservation reservation) {
        return new ReservationDto(
                reservation.getReservationId(),
                GuestDto.fromDomain(reservation.getGuest()),
                RoomDto.fromDomain(reservation.getRoom()),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date()
        );
    }
}
