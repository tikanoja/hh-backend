package fi.haagahelia.bookstore;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            Book book1 = new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968, "978-0345404473", 9.99);
            Book book2 = new Book("Neuromancer", "William Gibson", 1984, "978-0441569595", 12.99);
            Book book3 = new Book("Snow Crash", "Neal Stephenson", 1992, "978-0553380958", 14.99);
            Book book4 = new Book("The Three-Body Problem", "Cixin Liu", 2008, "978-0765382030", 13.99);
            Book book5 = new Book("Foundation", "Isaac Asimov", 1951, "978-0553293357", 9.49);


            repository.save(book1);
            repository.save(book2);
            repository.save(book3);
            repository.save(book4);
            repository.save(book5);
        };
    }

}
