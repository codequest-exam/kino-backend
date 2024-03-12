package dat3.kino.service;


import dat3.kino.entity.Reservation;
import dat3.kino.entity.Room;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room roomToAdd) {

        return roomRepository.save(roomToAdd);
    }
}
