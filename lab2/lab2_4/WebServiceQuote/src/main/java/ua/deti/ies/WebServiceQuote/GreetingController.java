package ua.deti.ies.WebServiceQuote;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    Movie[]  movies ={
        new Movie(1, "The Shining (1980)", "Little pigs, little pigs, let me come in! Not by the hair on your chinny chin chin? Then I'll huff... And I'll puff... And I'll blow your house in! "),
        new Movie(2, "Moonstruck (1987)", "Snap out of it!"),
        new Movie(3, "The Sandlot (1993)", "You're killing me, smalls! "),
        new Movie(4, "The Wizard of Oz (1939)", "Toto, I've got a feeling we're not in Kansas anymore."),
        new Movie(5, "The Terminator (1984)", "I'll be back."),
        new Movie(6, "The Sixth Sense (1999)", "I see dead people."),
        new Movie(7, "The Godfather (1972)", "I'm going to make him an offer he can't refuse."),
        new Movie(8, "The Princess Bride (1987)", "Hello. My name is Inigo Montoya. You killed my father. Prepare to die."),
        new Movie(9, "Jerry Maguire (1996)", "You had me at hello."),
        new Movie(10, "The Silence of the Lambs (1991)", "A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti."),
        new Movie(11, "The Dark Knight (2008)", "Why so serious?"),
        new Movie(12, "The Lord of the Rings: The Two Towers (2002)", "My precious."),
    };


    @GetMapping("/quotes")
	public Movie quote_movie(@RequestParam(value = "show") int id) {
		return movies[id-1];
	}

    @GetMapping("/shows")
	public Movie[] shows() {
		return movies;
	}

    @GetMapping("/quote")
	public Movie quote() {
		return movies[new Random().nextInt(movies.length-1)+1];
	}

        

    
}
