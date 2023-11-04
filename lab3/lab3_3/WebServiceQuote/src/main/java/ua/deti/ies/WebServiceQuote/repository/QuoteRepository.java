package ua.deti.ies.WebServiceQuote.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.deti.ies.WebServiceQuote.entity.Movie;
import ua.deti.ies.WebServiceQuote.entity.Quote;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByMovie(Movie movie);
    Quote findQuoteById(Long quoteId);
}