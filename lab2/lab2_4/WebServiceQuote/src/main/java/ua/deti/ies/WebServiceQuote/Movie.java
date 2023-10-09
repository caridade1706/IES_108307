package ua.deti.ies.WebServiceQuote;

public class Movie {

    private final int id;
	private final String quote;
    private final String title;

	public Movie(int id, String title, String quote) {
		this.id = id;
		this.quote = quote;
        this.title = title;
	}

	public long getId() {
		return id;
	}

	public String getQuote() {
		return quote;
	}


    public String getTitle() {
		return title;
	}
    
}
