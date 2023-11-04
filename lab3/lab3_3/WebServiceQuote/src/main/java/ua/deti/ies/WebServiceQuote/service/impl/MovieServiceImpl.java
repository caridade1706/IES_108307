package ua.deti.ies.WebServiceQuote.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ua.deti.ies.WebServiceQuote.entity.Movie;
import ua.deti.ies.WebServiceQuote.repository.MovieRepository;
import ua.deti.ies.WebServiceQuote.service.MovieService;

import java.util.List;
import java.util.Random;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    private Random random = new Random();

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createNewMovie(Movie movie) {
        System.out.println(movie.getTitle());
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long movieID) {
        return movieRepository.findMovieById(movieID);
    }

    @Override
    public Movie getRandomMovie() {
        Integer numberMovies = movieRepository.findAll().size();
        Integer randomNumber = random.nextInt(numberMovies-1)+1;
        return movieRepository.findMovieById(Long.valueOf(randomNumber));
    }
}