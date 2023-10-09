**Exercício 2.3**

Como pedido no enunciado comecee por criar uma nova web app (maven-supported, Spring Boot) em https://start.spring.io/, após o download no ficheiro é possível executá-lo através de 
```
$ mvn install -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar
or
$ ./mvnw spring-boot:run
```

De modo à realização da alínea b) segui o exemplo dado em 
https://spring.io/guides/gs/serving-web-content/, que possiblita a que haja uma determinada interaçãocom o utiliazador.

Esta interação é dada pela adição dos seguintes ficheiros

---GreetingController.java
```
@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
```

---index.html
```
<!DOCTYPE HTML>
<html>
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p>Get your greeting <a href="/greeting">here</a></p>
</body>
```

---greeting.html
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```


Quanto à realização da alínea c), que devolve o resultado no formato Jason, houve a alteação da seguinte classe, com base em https://spring.io/guides/gs/rest-service/

---GreetingController.java
```
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
```

E a criação de uma nova classe
---Greeting.java
```
public record Greeting(long id, String content) { }
```

Por último, e de modo a haver a alteraçãoda porta adiciondou-se a seguinte linha às application.properties
```
server.port=9000
```