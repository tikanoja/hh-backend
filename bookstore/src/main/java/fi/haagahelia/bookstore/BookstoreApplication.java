package fi.haagahelia.bookstore;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

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
    public CommandLineRunner demo(BookRepository brepository,
                                  CategoryRepository crepository) {
        return (args) -> {
            Category category1 = new Category("Sci-Fi");
            Category category2 = new Category("Horror");
            Category category3 = new Category("Fantasy");

            crepository.save(category1);
            crepository.save(category2);
            crepository.save(category3);

            Book book1 = new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968, "978-0345404473", 9.99, category1);
            Book book2 = new Book("Snow Crash", "Neal Stephenson", 1992, "978-0553380958", 14.99, category1);
            Book book3 = new Book("The Three-Body Problem", "Cixin Liu", 2008, "978-0765382030", 13.99, category1);

            Book book4 = new Book("The Shining", "Stephen King", 1977, "978-0307743657", 12.99, category2);
            Book book5 = new Book("At the Mountains of Madness", "H.P. Lovecraft", 1936, "978-0812974416", 8.99, category2);
            Book book6 = new Book("The Haunting of Hill House", "Shirley Jackson", 1959, "978-0143039982", 10.99, category2);

            Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0345339683", 10.99, category3);
            Book book8 = new Book("A Game of Thrones", "George R.R. Martin", 1996, "978-0553103540", 15.99, category3);
            Book book9 = new Book("The Way of Kings", "Brandon Sanderson", 2010, "978-0765326355", 16.99, category3);

            brepository.save(book1);
            brepository.save(book2);
            brepository.save(book3);
            brepository.save(book4);
            brepository.save(book5);
            brepository.save(book6);
            brepository.save(book7);
            brepository.save(book8);
            brepository.save(book9);
        };
    }

}
