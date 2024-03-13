package dat3.kino.controllers;

import dat3.kino.entity.Hall;
import dat3.kino.service.HallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class HallController {

    HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    public List<Hall> getAllRooms(){
        return hallService.getAll();
    }
    @PostMapping
    public Hall createRoom(@RequestBody Hall newRoom) {
        return hallService.addRoom(newRoom);
    }
}
