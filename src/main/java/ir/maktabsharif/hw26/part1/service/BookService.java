package ir.maktabsharif.hw26.part1.service;

import ir.maktabsharif.hw26.part1.model.Book;
import ir.maktabsharif.hw26.part1.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void add(String title, String author, String category, Double price) {
        bookRepository.add(title, author, category, price);
    }

    public List<Book> findByCategory(String category) {
        return bookRepository.findByCategory(category);
    }
}
