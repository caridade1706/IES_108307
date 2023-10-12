package ua.deti.ies.WebServiceQuote;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    Movie[]  movies ={
        new Movie(1, "The Shining (1980)", new Quote(1,"Little pigs, little pigs, let me come in! Not by the hair on your chinny chin chin? Then I'll huff... And I'll puff... And I'll blow your house in! ")),
        new Movie(2, "Moonstruck (1987)", new Quote(2,"Snap out of it!")),
        new Movie(3, "The Sandlot (1993)", new Quote(3,"You're killing me, smalls! ")),
        new Movie(4, "The Wizard of Oz (1939)", new Quote(4,"Toto, I've got a feeling we're not in Kansas anymore.")),
        new Movie(5, "The Terminator (1984)", new Quote(5,"I'll be back.")),
        new Movie(6, "The Sixth Sense (1999)", new Quote(6,"I see dead people.")),
        new Movie(7, "The Godfather (1972)", new Quote(7,"I'm going to make him an offer he can't refuse.")),
        new Movie(8, "The Princess Bride (1987)",new Quote(8,"Hello. My name is Inigo Montoya. You killed my father. Prepare to die.")),
        new Movie(9, "Jerry Maguire (1996)", new Quote(9,"You had me at hello.")),
        new Movie(10, "The Silence of the Lambs (1991)", new Quote(10,"A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.")),
        new Movie(11, "The Dark Knight (2008)", new Quote(11,"Why so serious?")),
        new Movie(12, "The Lord of the Rings: The Two Towers (2002)", new Quote(12, "My precious.")),
    };


    @GetMapping("/quotes")
	public Quote quote_movie(@RequestParam(value = "show") int id) {
		return movies[id-1].getQuote();
	}

    @GetMapping("/shows")
	public Movie[] shows() {
		return movies;
	}

    @GetMapping("/quote")
	public Quote quote() {
		return movies[new Random().nextInt(movies.length-1)+1].getQuote();
	}

        

    
}
