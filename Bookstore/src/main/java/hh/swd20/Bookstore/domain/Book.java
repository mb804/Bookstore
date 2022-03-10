package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	
	@Id // Primary key- määritys
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	// Attribuutit
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	@ManyToOne // Book @ManyToOne Category
	@JsonIgnoreProperties ("books") // Yksi tapa välttää loputon silmukka JSON-serialisoinnin/deserialoinnin aikana kaksisuuntaisilla suhteilla
	@JoinColumn(name = "categoryid") // Foreign key- määritys
	private Category category;

	// Parametrillinen konstruktori
	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	// Parametriton konstruktori
	public Book() {
	}
	
	// Setterit
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	// Getterit
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}
	
	// toString
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + " category =" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + "]";
	}
}
