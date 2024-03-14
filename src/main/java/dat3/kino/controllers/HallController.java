package dat3.kino.controllers;

import dat3.kino.entity.Hall;
import dat3.kino.service.HallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls/")
public class HallController {

    HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    public List<Hall> getAllRooms(){
        return hallService.getAll();
    }


    @GetMapping(path = "{id}")
    public Hall getRoomById(@PathVariable Long id){
        return hallService.findById(id);
    }

    @PostMapping
    public Hall createRoom(@RequestBody Hall newRoom) {
        return hallService.addRoom(newRoom);
    }

    @PutMapping(path = "{id}")
public Hall updateRoom(@RequestBody Hall roomToUpdate, @PathVariable Long id) {
        return hallService.updateRoom(roomToUpdate, id);
    }
}
