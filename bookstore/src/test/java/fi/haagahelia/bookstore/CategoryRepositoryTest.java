package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import fi.haagahelia.bookstore.domain.Book;
// import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
// import fi.haagahelia.bookstore.domain.User;
// import fi.haagahelia.bookstore.domain.UserRepository;


// @DataJpaTest //if you are using in-memory database, like H2
@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //if you are using real db
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository crepository;
    
    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = crepository.findByName("Horror");
        
        assertThat(categories).hasSize(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("test_category");
    	crepository.save(category);
    	assertThat(category.getId()).isNotNull();
    }

    @Test
    public void deleteNewCategory() {
        crepository.deleteAll(crepository.findByName("test_category"));
    
        Category category = new Category("test_category");
        crepository.save(category);
    
        List<Category> categories = crepository.findByName("test_category");
        assertThat(categories).isNotEmpty();
        crepository.delete(categories.get(0));
    
        List<Category> newCategories = crepository.findByName("test_category");
        assertThat(newCategories).isEmpty();
    }
    
}