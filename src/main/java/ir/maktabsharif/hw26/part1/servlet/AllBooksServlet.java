package ir.maktabsharif.hw26.part1.servlet;

import ir.maktabsharif.hw26.part1.model.Book;
import ir.maktabsharif.hw26.part1.service.BookService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "books", value = "/books")
public class AllBooksServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() {
        this.bookService = (BookService) getServletContext().getAttribute("bookService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String category = req.getParameter("category");

        List<Book> books;

        if (category == null || category.isBlank()) {
            books = bookService.findAll();
        } else {
            books = bookService.findByCategory(category);
        }

        PrintWriter out = resp.getWriter();

        out.println("""
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Products</title>
                </head>
                <body>
                <h1>Books List</h1>
                <ul>
                """);
        books.forEach(book -> out.println("<li>" + book + "</li>"));
        out.println("""
                </ul>
                </body>
                </html>
                """);
    }
}
