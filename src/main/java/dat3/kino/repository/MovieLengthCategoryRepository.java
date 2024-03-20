package dat3.kino.repository;

import dat3.kino.entity.MovieLengthCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieLengthCategoryRepository extends JpaRepository<MovieLengthCategory, String> {
}
