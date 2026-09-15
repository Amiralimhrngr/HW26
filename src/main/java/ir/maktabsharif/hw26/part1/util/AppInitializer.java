package ir.maktabsharif.hw26.part1.util;

import ir.maktabsharif.hw26.part1.repository.BookRepository;
import ir.maktabsharif.hw26.part1.service.BookService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);

        event.getServletContext().setAttribute("bookRepository", bookRepository);
        event.getServletContext().setAttribute("bookService", bookService);
    }
}
