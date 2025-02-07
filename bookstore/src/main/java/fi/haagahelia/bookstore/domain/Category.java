package fi.haagahelia.bookstore.domain;

import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnore // chapter 3, add ignore to prevent infinite reciursion when serializing
	private List<Book> books;
	
    // constructors
	public Category() {}
	public Category(String name) {
		super();
        this.name = name;
	}
	
    // getters
	public Long getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBooks() { return books; }

	// setters
	public void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setBooks(List<Book> books) { this.books = books; }

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
