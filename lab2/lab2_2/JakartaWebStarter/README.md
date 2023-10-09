**Exercício 2.2**

Neste exercício utilizamos o web server Apache Tomcat.

Desta forma começamos a criar o projeto maven com a particularidade de ser um JakartaEE aplicayion baseada num Web profile.

Após a criação do profeto adaptamos a classe principal de modo a executar algo semelhante ao exercício passado
```
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        String msg = request.getParameter("msg");

            if (msg != null){
                out.println("<h1>" + msg + "</h1>");
            }
            else{
                out.println("<h1>New Hello Simple Servlet</h1>");
            }
    }

```

Contudo de modo a funcionar houve a necessidade contruir um docker-compose.yml
```
version: '3'
services:
  tomcat:
    image: tomcat:10-jre11-openjdk-slim
    ports:
     - "8080:8080"
    volumes:
      - ./target/JakartaWebStarter-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/JakartaWebStarter-1.0-SNAPSHOT.war
```
que foi o que permitiu o deployment.
