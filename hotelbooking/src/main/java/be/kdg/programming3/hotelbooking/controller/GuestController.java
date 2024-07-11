package be.kdg.programming3.hotelbooking.controller;

import be.kdg.programming3.hotelbooking.domain.Guest;
import be.kdg.programming3.hotelbooking.service.GuestService;
import be.kdg.programming3.hotelbooking.viewmodel.GuestViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(final GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ModelAndView getAllGuests() {
        final ModelAndView modelAndView = new ModelAndView("guests");
        final List<Guest> issues = guestService.getAll();
        final List<GuestViewModel> viewModels = issues.stream().map(GuestViewModel::fromDomain).toList();
        modelAndView.addObject("guests", viewModels);
        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView getGuest(@PathVariable("id") int id) {
        final Guest guest = guestService.getById(id);
        if (guest == null) {
            return new ModelAndView("Not Found", HttpStatus.NOT_FOUND);
        }
        final ModelAndView modelAndView = new ModelAndView("guest");
        final GuestViewModel viewModel = GuestViewModel.fromDomainWithRooms(guest);
        modelAndView.addObject("guest", viewModel);
        return modelAndView;
    }
}
