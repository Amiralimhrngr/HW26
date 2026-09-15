package ir.maktabsharif.hw26.part1.servlet;

import ir.maktabsharif.hw26.part1.service.BookService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addBookServlet", value = "/books/add", initParams = {
        @WebInitParam(
                name = "maxBooks",
                value = "50"
        )})
public class AddBookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() {
        this.bookService = (BookService) getServletContext().getAttribute("bookService");
        ServletConfig servletConfig = getServletConfig();
        String maxBooks = servletConfig.getInitParameter("maxBooks");
        System.out.println("Max Books: " + maxBooks);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
                """
                        
                        <html>
                        <body>
                        <h1>Add book</h1>
                        <form method="POST" action="/HW26_war_exploded/books/add">
                        <label>Title: </label>
                        <input type="text" name="title" required>
                        <label>Author: </label>
                        <input type="text" name="author" required>
                        <label>Category: </label>
                        <input type="text" name="category" required>
                        <label>Price: </label>
                        <input type="text" name="price" required>
                        <button type="submit"> Add </button>
                        </form>
                        </body>
                        </html>
                        
                        """
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        String price = req.getParameter("price");
        Double priceDouble = Double.parseDouble(price);

        bookService.add(title, author, category, priceDouble);
    }
}
