package dat3.kino.service;


import dat3.kino.dto.HallResponseDto;
import dat3.kino.dto.SeatResponseDto;
import dat3.kino.entity.Hall;
import dat3.kino.entity.Seat;
import dat3.kino.repository.HallRepository;
import dat3.kino.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    HallRepository hallRepository;
    SeatRepository seatRepository;

    public HallService(HallRepository hallRepository, SeatRepository seatRepository) {
        this.hallRepository = hallRepository; this.seatRepository = seatRepository;
    }

    public Hall addRoom(Hall roomToAdd) {

        return hallRepository.save(roomToAdd);
    }

    public List<HallResponseDto> getAll() {
        return hallRepository.findAll().stream().map(HallResponseDto::new).toList();
    }

    public Hall findById(Long id) {
        return hallRepository.findById(id).orElse(null);
    }
    public Hall findByCinemaId(Long id) {
        return hallRepository.findByCinemaId(id);
    }

    public Hall updateRoom(Hall roomToUpdate, Long id) {
        Hall room = hallRepository.findById(id).orElse(null);
        if (room == null) {
            return null;
        }
        roomToUpdate.setId( room.getId());

        return hallRepository.save(roomToUpdate);
    }

    public List<SeatResponseDto> getSeatsByRoom(Long hallId) {
        System.out.println("@@@@@@@ SEAT PRICE CLASS" +seatRepository.findById(1L).get().getPriceClass().getPrice());
        List<Seat> seats = seatRepository.findAllByHallId(hallId);
        return seats.stream().map(SeatResponseDto::new).toList();
        //return seatRepository.findAllByHallId(hallId);
    }
}
