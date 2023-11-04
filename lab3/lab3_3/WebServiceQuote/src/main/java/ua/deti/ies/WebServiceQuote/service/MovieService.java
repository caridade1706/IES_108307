package ua.deti.ies.WebServiceQuote.service;

import ua.deti.ies.WebServiceQuote.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie createNewMovie(Movie movie);
    Movie getMovieById(Long movieID);
    Movie getRandomMovie();
}