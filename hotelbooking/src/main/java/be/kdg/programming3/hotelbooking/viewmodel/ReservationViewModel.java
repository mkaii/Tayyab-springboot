package be.kdg.programming3.hotelbooking.viewmodel;

import be.kdg.programming3.hotelbooking.domain.Reservation;

import java.time.LocalDate;

public record ReservationViewModel(
        int reservationId,
        GuestViewModel guest,
        RoomViewModel room,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {
    public static ReservationViewModel fromDomain(Reservation reservation) {
        return new ReservationViewModel(
                reservation.getReservationId(),
                GuestViewModel.fromDomain(reservation.getGuest()),
                RoomViewModel.fromDomain(reservation.getRoom()),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date()
        );
    }
}
