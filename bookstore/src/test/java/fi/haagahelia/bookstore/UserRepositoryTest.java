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
// import fi.haagahelia.bookstore.domain.Category;
// import fi.haagahelia.bookstore.domain.CategoryRepository;
import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;


// @DataJpaTest //if you are using in-memory database, like H2
@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //if you are using real db
public class UserRepositoryTest {

    @Autowired
    private UserRepository urepository;
    
    @Test
    public void findByNameShouldReturnUser() {
        User user = urepository.findByUsername("admin");
        
        assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("testuser", "test@email.com", "pwhash", "testuser");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteNewUser() {
        User existingUser = urepository.findByUsername("testuser");
        if (existingUser != null) {
            urepository.delete(existingUser);
        }
    
        User newUser = new User("testuser", "testemail@example.com", "password", "ROLE_USER");
        urepository.save(newUser);
    
        User foundUser = urepository.findByUsername("testuser");
        assertThat(foundUser).isNotNull();
    
        urepository.delete(foundUser);
        assertThat(urepository.findByUsername("testuser")).isNull();
    }
    
}