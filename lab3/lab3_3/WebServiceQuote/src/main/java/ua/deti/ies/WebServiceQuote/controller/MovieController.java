package ua.deti.ies.WebServiceQuote.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.deti.ies.WebServiceQuote.entity.Movie;
import ua.deti.ies.WebServiceQuote.entity.Quote;
import ua.deti.ies.WebServiceQuote.service.MovieService;
import ua.deti.ies.WebServiceQuote.service.QuoteService;
import java.util.List;


import java.util.List;

@RestController
@AllArgsConstructor

public class MovieController {

    private MovieService movieService;
    private QuoteService quoteService;

    // Retrun a random quote from a movie
    @GetMapping("/quote")
    public ResponseEntity<Quote> randomQuote() {
        Quote randomQuote = quoteService.getRandomQuote(movieService.getRandomMovie());
        return new ResponseEntity<>(randomQuote, HttpStatus.OK);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/quotes/{id}")
    public ResponseEntity<List<Quote>> getQuotesByMovie(@PathVariable("id") Long movieId) {    
        List<Quote> quotes = quoteService.getQuoteByMovie(movieService.getMovieById(movieId));
        return new ResponseEntity<>(quotes, HttpStatus.CREATED);
    }

    // List of all available movies, (from which some quotes exists).
    @GetMapping("/shows")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.CREATED);
    }

   // Adding a new movie to the database
   @PostMapping("/shows")
   public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movie) {
       Movie newMovie = movieService.createNewMovie(movie);
       return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
   }


    // Adding a new quote to the database
    @PostMapping("/quote")
    public ResponseEntity<Quote> createNewQuote(@RequestBody Quote quote) {
        Quote newQuote = quoteService.createNewQuote(quote);
        return new ResponseEntity<>(newQuote, HttpStatus.CREATED);
    }
    
}
