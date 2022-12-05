package com.digitalbook.entity;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
@Table(name ="BOOKS")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer book_Id;
	
	
	@Column(name="LOGO_ID")
	Blob logo;
	
	@NotBlank
	@Size(min=10 ,max=50)
	@Column(name="TITLE")
	private String title;
	
	@NotBlank
	@Size(min=10 ,max=50)
	@Column(name="Category")
	private String category;
	
	@NotBlank
	@Column(name="Price")
	private double price;
	
	@NotBlank
	@Size(min=10 ,max=50)
	@Column(name="AUTHOR")
	private String author;
	
	@NotBlank
	@Size(min=10 ,max=50)
	@Column(name="PUBLISHER")
	private String publisher;
	
	@NotBlank
	@Column(name="PUBLISHED_DATE")
	private LocalDate publishedDate; 
	
	
	@Column(name="ACTIVE")
	private boolean active;
	
	@NotBlank
	@Size(min=100)
	@Column(name="CONTENT")
	private String content;

	public Book() {
		super();
		
	}

	public Book( Blob logo, String title, String category, double price, String author, String publisher,
			LocalDate publishedDate, boolean active, String content) {
		super();
		
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.active = active;
		this.content = content;
	}

	public Integer getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(Integer book_Id) {
		this.book_Id = book_Id;
	}

	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Book [book_Id=" + book_Id + ", logo=" + logo + ", title=" + title + ", category=" + category
				+ ", price=" + price + ", authorId=" + author + ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", active=" + active + ", content=" + content + "]";
	}
	
	
	
	

	
	
}
