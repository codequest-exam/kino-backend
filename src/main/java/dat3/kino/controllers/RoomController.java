package dat3.kino.controllers;

import dat3.kino.entity.Room;
import dat3.kino.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAll();
    }
    @PostMapping
    public Room createRoom(@RequestBody Room newRoom) {
        return roomService.addRoom(newRoom);
    }
}
