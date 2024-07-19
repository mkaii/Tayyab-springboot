package be.kdg.programming3.hotelbooking.controller;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.domain.Reservation;
import be.kdg.programming3.hotelbooking.service.GuestService;
import be.kdg.programming3.hotelbooking.service.ReservationService;
import be.kdg.programming3.hotelbooking.viewmodel.GuestViewModel;
import be.kdg.programming3.hotelbooking.viewmodel.ReservationViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    private final ReservationService reservationService;

    public GuestController(final GuestService guestService, ReservationService reservationService) {
        this.guestService = guestService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public ModelAndView getAllGuests() {
        final ModelAndView modelAndView = new ModelAndView("guests");
        final List<Guest> guests = guestService.getAll();
        final List<GuestViewModel> viewModels = guests.stream().map(GuestViewModel::fromDomain).toList();
        modelAndView.addObject("guests", viewModels);
        return modelAndView;
    }

    @GetMapping("/{guestId}")
    public ModelAndView getGuest(@PathVariable("guestId") int guestId) {
        final Guest guest = guestService.getById(guestId);
        if (guest == null) {
            return new ModelAndView("notfound", HttpStatus.NOT_FOUND);
        }
        final ModelAndView modelAndView = new ModelAndView("guest");
        final GuestViewModel viewModel = GuestViewModel.fromDomain(guest);
        modelAndView.addObject("guest", viewModel);
        return modelAndView;
    }

    @GetMapping("/search")
    public String searchGuests(){
        return "searchguests";
    }


    @GetMapping("/{guestId}/reserved")
    @ResponseBody
    public List<ReservationViewModel> getReservedRooms(@PathVariable("guestId") int guestId) {
        final List<Reservation> reservations = reservationService.findByGuestId(guestId);
        return reservations.stream()
                .map(ReservationViewModel::fromDomain)
                .collect(Collectors.toList());
    }

}
