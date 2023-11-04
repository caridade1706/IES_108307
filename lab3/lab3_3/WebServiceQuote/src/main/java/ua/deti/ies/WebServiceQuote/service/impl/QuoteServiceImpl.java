package ua.deti.ies.WebServiceQuote.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.deti.ies.WebServiceQuote.entity.Movie;
import ua.deti.ies.WebServiceQuote.entity.Quote;
import ua.deti.ies.WebServiceQuote.repository.QuoteRepository;
import ua.deti.ies.WebServiceQuote.service.QuoteService;

import java.util.List;
import java.util.Random;
@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private QuoteRepository quotesRepository;

    private Random random = new Random();
    @Override
    public List<Quote> getQuoteByMovie(Movie movie) {
        return quotesRepository.findByMovie(movie);
    }
    @Override
    public Quote getRandomQuote(Movie movie) {
        List<Quote> quotes = quotesRepository.findByMovie(movie);
        if (quotes.size() > 0) {
            Integer randomNumber = random.nextInt(quotes.size());
            return quotes.get(randomNumber);
        }
        return null;
    }

    @Override
    public Quote createNewQuote(Quote quote) {
        return quotesRepository.save(quote);
    }

}