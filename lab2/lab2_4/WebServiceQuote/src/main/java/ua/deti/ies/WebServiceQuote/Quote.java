package ua.deti.ies.WebServiceQuote;

public class Quote {

   
    public int id;
    public String quote;

    public Quote(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

}
