package com.mac.bry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="release_date")
	private int releaseDate;
	
	@Column(name="pages")
	private int pages;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="isbn")
	private String isbn;

	public Book(String title, String author, int releaseDate, int pages, String publisher, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
		this.pages = pages;
		this.publisher = publisher;
		this.isbn = isbn;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", releaseDate=" + releaseDate
				+ ", pages=" + pages + ", publisher=" + publisher + ", isbn=" + isbn + "]";
	}
	
	
	
}
