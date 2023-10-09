**Exercício 2.1**

Para a realização do proposto basei-me no exemplo cedido no guião "embedded server example using the Jetty server" (https://examples.javacodegeeks.com/java-development/enterprise-java/jetty/embedded-jetty-server-example/).

Contudo para a realização da alínea b) alterei o que foi realizado na alínea anterior modificando a classe 'public static class HelloServlet extends HttpServlet ' para o seguinte:

```
public static class HelloServlet extends HttpServlet
    {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);

            String msg = request.getParameter("msg");

            if (msg != null){
                response.getWriter().println("<h1>" + msg + "</h1>");
            }
            else{
                response.getWriter().println("<h1>New Hello Simple Servlet</h1>");
            }
        }
    }
```