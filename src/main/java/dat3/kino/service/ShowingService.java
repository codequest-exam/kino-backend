package dat3.kino.service;


import dat3.kino.entity.Room;
import dat3.kino.entity.Showing;
import dat3.kino.repository.RoomRepository;
import dat3.kino.repository.ShowingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowingService {

    ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public Showing addShowing(Showing showingToAdd) {

        return showingRepository.save(showingToAdd);
    }
}
