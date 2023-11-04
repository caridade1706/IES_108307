package ua.deti.ies.WebServiceQuote.service;

import ua.deti.ies.WebServiceQuote.entity.Movie;
import ua.deti.ies.WebServiceQuote.entity.Quote;

import java.util.List;

public interface QuoteService {
    List<Quote> getQuoteByMovie(Movie movie);
    Quote getRandomQuote(Movie movie);

    Quote createNewQuote(Quote quote);
}