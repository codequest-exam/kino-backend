package dat3.kino.service;


import dat3.kino.dto.HallResponseDto;
import dat3.kino.entity.Hall;
import dat3.kino.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
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
}
