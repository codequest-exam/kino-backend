package dat3.kino.repository;

import dat3.kino.entity.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Long> {

     List<Showing> findAllByMovieId(Long id);
}
