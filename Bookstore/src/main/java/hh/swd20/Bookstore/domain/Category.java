package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Category {
	
	@Id // Primary key määritys tietokannan Category-taululle
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	// Attribuutit
	private Long categoryid;
	private String name;
	
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
	
	// Getterit
	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}
	
	// toString
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
}
