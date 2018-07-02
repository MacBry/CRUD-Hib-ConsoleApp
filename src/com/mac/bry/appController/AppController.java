package com.mac.bry.appController;

import com.mac.bry.database.Library;
import com.mac.bry.utils.DataReader;

public class AppController {

	//Main menu options
	public static final int ADD_BOOK = 1;
	public static final int SHOW_BOOKS = 2;
	public static final int FIND = 3;
	public static final int DELETE = 4;
	public static final int EDIT = 5;
	public static final int EXIT = 0;
	
	//Find menu options
	public static final int FIND_BY_TITLE = 1;
	public static final int FIND_BY_AUTHOR = 2;
	public static final int FIND_BY_RELEASE_DATE = 3;
	public static final int FIND_BY_NUMBER_OF_PAGES = 4;
	public static final int FIND_BY_PUBLISHER = 5;
	public static final int FIND_BY_ISBN = 6;
	public static final int FIND_EXIT = 0;
	
	//Delete menu options
	public static final int DELETE_BY_TITLE = 1;
	public static final int DELETE_BY_AUTHOR = 2;
	public static final int DELETE_BY_RELEASE_DATE = 3;
	public static final int DELETE_BY_NUMBER_OF_PAGES = 4;
	public static final int DELETE_BY_PUBLISHER = 5;
	public static final int DELETE_BY_ISBN = 6;
	public static final int DELETE_EXIT = 0;
	
	//EDIT menu options
	public static final int EDIT_BY_TITLE = 1;
	public static final int EDIT_BY_AUTHOR = 2;
	public static final int EDIT_BY_RELEASE_DATE = 3;
	public static final int EDIT_BY_NUMBER_OF_PAGES = 4;
	public static final int EDIT_BY_PUBLISHER = 5;
	public static final int EDIT_BY_ISBN = 6;
	public static final int EDIT_EXIT = 0;
	
	private DataReader dataReader;
	private Library library;
	
	public AppController() {
		super();
		this.dataReader = new DataReader();
		this.library = new Library();
	}
	
	public void programLoop(){
		printMainOption();
		int option;
		
		while((option = dataReader.readNumber()) != EXIT) {
			
			switch (option) {
			
			case ADD_BOOK:
				library.addBook(dataReader.readAndCreateBook());
				break;
				
			case SHOW_BOOKS:
				library.readBooks();
				break;

			case FIND:
				FindLoop();
				break;
				
			case DELETE:
				DeleteLoop();
				break;
				
			case EDIT:
				EditLoop();
				break;
				
				
			default:
				System.out.println("Ther is no such option");
				break;
			}
			printMainOption();
		}
	}
	
	public void FindLoop() {
		printFindOption();
		int FindOption;
		
		while((FindOption = dataReader.readNumber()) != FIND_EXIT) {
			
			switch (FindOption) {
			
			case FIND_BY_TITLE:
				System.out.println("Enter book title: ");
				library.findBooksByTitle(dataReader.readString());
				break;

			case FIND_BY_AUTHOR:
				System.out.println("Enter book author: ");
				library.findBooksByAuthor(dataReader.readString());
				break;
			
			case FIND_BY_RELEASE_DATE:
				System.out.println("Enter release year: ");
				library.findBooksByRelease(dataReader.readNumber());
				break;
				
			case FIND_BY_NUMBER_OF_PAGES:
				System.out.println("Enter number of pages: ");
				library.findBooksByNumberOfPages(dataReader.readNumber());
				break;
				
			case FIND_BY_PUBLISHER:
				System.out.println("Enter publisher: ");
				library.findBooksByPublisher(dataReader.readString());
				break;
				
			case FIND_BY_ISBN:
				System.out.println("Enter ISBN number: ");
				library.findBooksByISBN(dataReader.readString());
				break;
			
			default:
				System.out.println("Ther is no such option");
				break;
			}
			printFindOption();
		}
	}
	
	public void DeleteLoop() {
		printDeleteOption();
		int deleteOption;
		
		while((deleteOption = dataReader.readNumber()) != DELETE_EXIT) {
			switch (deleteOption) {
			
			case DELETE_BY_TITLE:
				System.out.println("Enter book title: ");
				library.deleteBooksByTitle(dataReader.readString());
				break;

			case DELETE_BY_AUTHOR:
				System.out.println("Enter book author: ");
				library.deleteBooksByAuthor(dataReader.readString());
				break;
			
			case DELETE_BY_RELEASE_DATE:
				System.out.println("Enter release year: ");
				library.deleteBooksByRelease(dataReader.readNumber());
				break;
				
			case DELETE_BY_NUMBER_OF_PAGES:
				System.out.println("Enter number of pages: ");
				library.deleteBooksByNumberOfPages(dataReader.readNumber());
				break;
				
			case DELETE_BY_PUBLISHER:
				System.out.println("Enter publisher: ");
				library.deleteBooksByPublisher(dataReader.readString());
				break;
				
			case DELETE_BY_ISBN:
				System.out.println("Enter ISBN number: ");
				library.deleteBooksByISBN(dataReader.readString());
				break;
			
			default:
				System.out.println("Ther is no such option");
				break;
			}
			printDeleteOption();
		}
	}
		
	public void EditLoop() {
		printEditOption();
		int editOption;
		
		while((editOption = dataReader.readNumber()) != EDIT_EXIT) {
			switch (editOption) {
			
			case EDIT_BY_TITLE:
				System.out.println("Enter book id: ");
				library.editBookTitle(library.selectBookById(dataReader.readNumber()), dataReader.readString());
				break;

			case EDIT_BY_AUTHOR:
				System.out.println("Enter book id: ");
				library.editBookAuthor(library.selectBookById(dataReader.readNumber()), dataReader.readString());
				break;
			
			case EDIT_BY_RELEASE_DATE:
				System.out.println("Enter book id: ");
				library.editBookRelease(library.selectBookById(dataReader.readNumber()), dataReader.readNumber());
				break;
				
			case EDIT_BY_NUMBER_OF_PAGES:
				System.out.println("Enter book id: ");
				library.editBoookPages(library.selectBookById(dataReader.readNumber()), dataReader.readNumber());
				break;
				
			case EDIT_BY_PUBLISHER:
				System.out.println("Enter book id: ");
				library.editBookPublisher(library.selectBookById(dataReader.readNumber()), dataReader.readString());
				break;
				
			case EDIT_BY_ISBN:
				System.out.println("Enter book id: ");
				library.editBookISBN(library.selectBookById(dataReader.readNumber()), dataReader.readString());
				break;
			
			default:
				System.out.println("Ther is no such option");
				break;
			}
			printEditOption();
		}
	}
	
	
	public void printMainOption() {
		System.out.println("===================================");
		System.out.println("You are in Mine menu");
		System.out.println("===================================");
		System.out.println("Choose main option: ");
		System.out.println("1. Add book.");
		System.out.println("2. Show books.");
		System.out.println("3. FIND Menu");
		System.out.println("4. DELETE Menu");
		System.out.println("5. EDIT book by id menu");
		System.out.println("0. Exit.");
	}
	
	public void printFindOption() {
		System.out.println("===================================");
		System.out.println("You are in Find menu");
		System.out.println("===================================");
		System.out.println("Choose find option: ");
		System.out.println("1. Find by title");
		System.out.println("2. Find by author");
		System.out.println("3. Find by release date");
		System.out.println("4. Find by number of pages");
		System.out.println("5. Find by publisher");
		System.out.println("5. Find by ISBN");
		System.out.println("0. Exit to main menu");
	}
	
	public void printDeleteOption() {
		System.out.println("===================================");
		System.out.println("You are in Delete menu");
		System.out.println("===================================");
		System.out.println("Choose find option: ");
		System.out.println("1. Delete by title");
		System.out.println("2. Delete by author");
		System.out.println("3. Delete by release date");
		System.out.println("4. Delete by number of pages");
		System.out.println("5. Delete by publisher");
		System.out.println("5. Delete by ISBN");
		System.out.println("0. Exit to main menu");
	}
	
	public void printEditOption() {
		System.out.println("===================================");
		System.out.println("You are in EDIT menu");
		System.out.println("===================================");
		System.out.println("Choose find option: ");
		System.out.println("1. Edit  title");
		System.out.println("2. Edit  author");
		System.out.println("3. Edit  release date");
		System.out.println("4. Edit  number of pages");
		System.out.println("5. Edit  publisher");
		System.out.println("5. Edit  ISBN");
		System.out.println("0. Exit to main menu");
	}
}
