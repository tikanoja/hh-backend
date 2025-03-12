package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
// import fi.haagahelia.bookstore.domain.User;
// import fi.haagahelia.bookstore.domain.UserRepository;


// @DataJpaTest //if you are using in-memory database, like H2
@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //if you are using real db
public class BookRepositoryTest {

    //in test cases field injection can be used
    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;
    
    @Test
    public void findByNameShouldReturnBook() {
        List<Book> books = brepository.findByTitle("Snow Crash");
        
        assertThat(books).hasSize(1);
    }
    
    @Test
    public void createNewBook() {
    	Category category = new Category("test_category");
    	crepository.save(category);
    	Book test_book = new Book("bookname", "authorname", 2000, "isbn", 10.99, category);
    	brepository.save(test_book);
    	assertThat(test_book.getId()).isNotNull();
    }    
    @Test
    public void deleteNewBook() {
		List<Book> books = brepository.findByTitle("bookname");
		Book student = books.get(0);
		brepository.delete(student);
		List<Book> newBooks = brepository.findByTitle("bookname");
		assertThat(newBooks).hasSize(0);
     }

}