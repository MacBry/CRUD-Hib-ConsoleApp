package com.mac.bry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="test message title")
	@Column(name="title")
	private String title;
	
	@NotNull
	@Column(name="author")
	private String author;
	
	@NotNull
	@Min(value=1800)
	@Column(name="release_date")
	private int releaseDate;
	
	@NotNull
	@Min(value=0)
	@Column(name="pages")
	private int pages;
	
	@NotNull
	@Column(name="publisher")
	private String publisher;
	
	@NotNull
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
	
	public static void printFirstTableRow() {
		System.out.println();
		for(int i = 0 ; i <=158; i++) {
			System.out.print("=");
		}
		System.out.println();
		
		System.out.printf("%-5s || %-50s || %-25s || %-12s || %-5s || %-25s || %-10s ||\n", "ID" ,"TITLE", "AUTHOR", "RELEASE DATE", "PAGES", "PUBLISHER", "ISBN");
		for(int i = 0 ; i <=158; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public static void printLastTableRow() {
		for(int i = 0 ; i <=158; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public void PrintTableRow() {
		System.out.printf("%-5d || %-50s || %-25s || %-12d || %-5d || %-25s || %-10s ||\n" , id ,title, author, releaseDate, pages, publisher, isbn);
	}
	
	
}
