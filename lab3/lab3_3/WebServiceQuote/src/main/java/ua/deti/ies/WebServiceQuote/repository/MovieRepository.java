package ua.deti.ies.WebServiceQuote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.deti.ies.WebServiceQuote.entity.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMovieByTitle(String title);
    Movie findMovieById(Long id);

}