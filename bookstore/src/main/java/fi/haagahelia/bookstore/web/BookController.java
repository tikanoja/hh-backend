package fi.haagahelia.bookstore.web;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    // // chpater 1
    // private final List<Book> books = new ArrayList<>();
    // chapter 2
    @Autowired
    private BookRepository brepository;

    @Autowired
	private CategoryRepository crepository;

    // // chapter 1
    // @GetMapping("/index")
    // public String index(Model model) {
    //     books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968, "978-0345404473", 9.99));
    //     books.add(new Book("Neuromancer", "William Gibson", 1984, "978-0441569595", 12.99));
    //     books.add(new Book("Snow Crash", "Neal Stephenson", 1992, "978-0553380958", 14.99));

    //     model.addAttribute("books", books);
    //     return "index";
    // }
    
    // // chapter 1
    // @GetMapping("/books")
    // public String listBooks(Model model) {
    //     model.addAttribute("book", books);
    //     return "books"; // render the html template
    // }

    // // chapter 1
    // @PostMapping("/books")
    // public String addBook(
    //     @RequestParam("title") String title,
    //     @RequestParam("author") String author,
    //     @RequestParam("publicationYear") int publicationYear,
    //     @RequestParam("isbn") String isbn,
    //     @RequestParam("price") double price) {
    //     books.add(new Book(title, author, publicationYear, isbn, price));
    //     return "redirect:/books"; // redir to refresh page
    // }

    // chapter 2
    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }

    // chapter 2
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addBook";
    }
    
    // chapter 2
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }
    
    // chapter 2
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        brepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // chapter 2
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = brepository.findById(bookId).orElse(null);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("categories", crepository.findAll());
            return "editBook";
        } else {
            return "redirect:/booklist";
        }
    }

    // chapter 3
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) brepository.findAll();
    }

    // chapter 3
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
        return brepository.findById(bookId);
    }
}
