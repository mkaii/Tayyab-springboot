package be.kdg.programming3.hotelbooking.controller;

import be.kdg.programming3.hotelbooking.domain.Reservation;
import be.kdg.programming3.hotelbooking.service.ReservationService;
import be.kdg.programming3.hotelbooking.viewmodel.ReservationViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ModelAndView getAllReservations() {
        final ModelAndView modelAndView = new ModelAndView("reservations");
        final List<Reservation> reservations = reservationService.getAll();
        final List<ReservationViewModel> viewModels = reservations.stream().map(ReservationViewModel::fromDomain).toList();
        modelAndView.addObject("reservations", viewModels);
        return modelAndView;
    }

    @GetMapping("/{reservationId}")
    public ModelAndView getReservation(@PathVariable("reservationId") int reservationId) {
        final Reservation reservation = reservationService.getById(reservationId);
        if (reservation == null) {
            return new ModelAndView("notfound", HttpStatus.NOT_FOUND);
        }
        final ModelAndView modelAndView = new ModelAndView("reservation");
        final ReservationViewModel viewModel = ReservationViewModel.fromDomain(reservation);
        modelAndView.addObject("reservation", viewModel);
        return modelAndView;
    }
}
