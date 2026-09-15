package ir.maktabsharif.hw26.part1.repository;

import com.github.javafaker.Faker;
import ir.maktabsharif.hw26.part1.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final Faker faker = new Faker();
    private static final List<Book> books = new ArrayList<>(
      List.of(
              new Book(1L,faker.book().title() ,faker.book().author(),faker.book().genre(), 10.0 ),
              new Book(2L,faker.book().title() ,faker.book().author(),faker.book().genre(), 20.0 ),
              new Book(3L,faker.book().title() ,faker.book().author(),faker.book().genre(), 30.0 ),
              new Book(4L,faker.book().title() ,faker.book().author(),faker.book().genre(), 40.0 ),
              new Book(5L,faker.book().title() ,faker.book().author(),faker.book().genre(), 50.0 ),
              new Book(6L,faker.book().title() ,faker.book().author(),faker.book().genre(), 60.0 )
      )
    );

    public List<Book> findAll() {
        return books;
    }

    public void add(String title, String author, String category, Double price) {
        Long id = (long) (books.size() + 1);
        Book book = new Book(id, title, author, category, price);
        books.add(book);
    }

    public List<Book> findByCategory(String category) {
//        return books.stream()
//                .filter(book -> book.getCategory().equalsIgnoreCase(category))
//                .toList();
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

}
