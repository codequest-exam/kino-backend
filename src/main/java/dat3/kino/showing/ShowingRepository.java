package dat3.kino.showing;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Long> {

     List<Showing> findAllByMovieId(Long id);
}
