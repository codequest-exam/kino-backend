package dat3.kino.repository;

import dat3.kino.reservation.MovieLengthCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieLengthCategoryRepository extends JpaRepository<MovieLengthCategory, String> {
}
