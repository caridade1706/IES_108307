package ua.deti.ies.WebServiceQuote;

public class Movie {

    private final int id;
	private final Quote quote;
    private final String title;

	public Movie(int id, String title, Quote quote) {
		this.id = id;
		this.quote = quote;
        this.title = title;
	}

	public long getId() {
		return id;
	}

	public Quote getQuote() {
		return quote;
	}


    public String getTitle() {
		return title;
	}
    
}
