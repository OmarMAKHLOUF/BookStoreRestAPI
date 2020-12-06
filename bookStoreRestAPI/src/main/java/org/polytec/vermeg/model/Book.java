package org.polytec.vermeg.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="Book")
public class Book {

	@Id
	@Column(name="id_book")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_book;
	
	@Column(name="title")
	String title;	
	
	@Column(name="author")
	String author;	
	
	@Column(name="price")
	int price;
	
	@Column(name="releaseDate")
	Date releaseDate;
	
	@OneToMany(mappedBy="book", fetch = FetchType.EAGER)
	private List<Commande_ligne> commandeLines;
	
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Book(int id_book, String title, String author, int price, Date releaseDate) {
		super();
		this.id_book = id_book;
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
	}
	 
	 
	public Book( ) {
		super();
		 
	}
	 
	
}
