package be.kdg.programming3.hotelbooking.controller;

import be.kdg.programming3.hotelbooking.domain.Room;
import be.kdg.programming3.hotelbooking.service.RoomService;
import be.kdg.programming3.hotelbooking.viewmodel.RoomViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(final RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public ModelAndView getAllRooms(){
        final ModelAndView modelAndView = new ModelAndView("rooms");
        final List<Room> rooms = roomService.getAll();
        final List<RoomViewModel> viewModels  = rooms.stream().map(RoomViewModel::fromDomain).toList();
        modelAndView.addObject("rooms",viewModels);
        return modelAndView;
    }

    @GetMapping("/{roomId}")
    public ModelAndView getRoom(@PathVariable("roomId") int roomId){
        final Room room = roomService.getById(roomId);
        if (room == null) {
            return new ModelAndView("notfound", HttpStatus.NOT_FOUND);
        }
        final ModelAndView modelAndView = new ModelAndView("room");
        final RoomViewModel viewModel = RoomViewModel.fromDomainWithGuests(room);
        modelAndView.addObject("room",viewModel);
        return modelAndView;
    }
}
