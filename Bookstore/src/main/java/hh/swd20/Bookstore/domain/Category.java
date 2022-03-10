package hh.swd20.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Category {
	
	@Id // Primary key määritys tietokannan Category-taululle
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	// Attribuutit
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // Category @OneToMany Book
	// mappedBy -> viittaa Book-luokan siihen attribuuttiin (category), joka viittaa ko. luokkaan (Category)
	
	@JsonIgnoreProperties ("category") // Yksi tapa välttää loputon silmukka JSON-serialisoinnin/deserialoinnin aikana kaksisuuntaisilla suhteilla
	private List<Book> books;
	
	// Parametrillinen konstruktori
	public Category(String name) {
		super();
		this.name = name;
	}
	
	// Parametriton konstruktori
	public Category() {}
	
	// Setterit
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	// Getterit
	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	// toString
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
}
