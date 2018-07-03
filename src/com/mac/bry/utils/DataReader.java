package com.mac.bry.utils;

import java.util.Scanner;

import com.mac.bry.entity.Book;

public class DataReader {

	private Scanner scanner;
	private BookValidator bookValidator;

	public DataReader() {
		super();
		this.scanner = new Scanner(System.in);
		this.bookValidator = new BookValidator();
	}
	
	public void CloseScanner() {
		scanner.close();
	}
	
	public int readNumber() {
		int tempNumb;
		tempNumb = scanner.nextInt();
		scanner.nextLine();
		return tempNumb;
	}
	
	public String readString() {
		String tempString = scanner.nextLine();
		return tempString;
	}
	
	public Book readAndCreateBook() {
		
		System.out.println("Title: ");
		String tempTitle = scanner.nextLine();
		
		System.out.println("Author: ");
		String tempAuthor = scanner.nextLine();
		
		System.out.println("Release Date: ");
		int tempReleaseDate = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Pages: ");
		int tempPages = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Publisher: ");
		String tempPublisher = scanner.nextLine();
		
		System.out.println("ISBN: ");
		String tempISBN = scanner.nextLine();
		
		Book tempBook = new Book(tempTitle, tempAuthor, tempReleaseDate, tempPages,tempPublisher, tempISBN );
		
		bookValidator.validBook(tempBook);
		
		return tempBook;
	}
	
}
