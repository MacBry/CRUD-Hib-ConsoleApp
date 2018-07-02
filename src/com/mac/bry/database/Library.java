package com.mac.bry.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.bry.entity.Book;

public class Library {

	private SessionFactory factory;

	public Library() {
		super();
		this.factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Book.class)
				.buildSessionFactory();
	}
	
	public void addBook (Book book) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readBooks() {
		try {
			List<Book> booksList;
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//FIND METHODS
	public void findBooksByTitle(String tempTitle) {
		try {
			List<Book> booksList;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book book where book.title='" + tempTitle + "'").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findBooksByAuthor(String tempAuthor) {
		try {
			List<Book> booksList;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book book where book.author='" + tempAuthor + "'").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findBooksByRelease(int tempYear) {
		try {
			List<Book> booksList;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book book where book.releaseDate='" + tempYear + "'").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findBooksByNumberOfPages(int tempPageNumb) {
		try {
			List<Book> booksList;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book book where book.pages='" + tempPageNumb + "'").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findBooksByPublisher(String tempPublisher) {
		try {
			List<Book> booksList;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book book where book.publisher='" + tempPublisher + "'").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findBooksByISBN(String tempISBN) {
		try {
			List<Book> booksList;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			booksList = session.createQuery("from Book book where book.isbn='" + tempISBN + "'").getResultList();
			printBookList(booksList);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//DELETE METHODS
	public void deleteBooksByTitle(String tempTitle) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Book book where book.title='" + tempTitle + "'").executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteBooksByAuthor(String tempAuthor) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Book book where book.title='" + tempAuthor + "'").executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteBooksByRelease(int tempYear) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Book book where book.title='" + tempYear + "'").executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteBooksByNumberOfPages(int tempPageNumb) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Book book where book.title='" + tempPageNumb + "'").executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteBooksByPublisher(String tempPublisher) {	
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Book book where book.title='" + tempPublisher + "'").executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBooksByISBN(String tempISBN) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Book book where book.title='" + tempISBN + "'").executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	//EDIT METHODS
	public void editBookTitle(Book tempBook, String newTitle) {
		String oldTitle = tempBook.getTitle();
		Session session = factory.getCurrentSession();
		tempBook.setTitle(newTitle);
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldTitle + " to " + tempBook.getTitle());
	}
	
	public void editBookAuthor(Book tempBook, String newAuthor) {
		String oldAuthor = tempBook.getAuthor();
		Session session = factory.getCurrentSession();
		tempBook.setAuthor(newAuthor);
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldAuthor + " to " + tempBook.getAuthor());
	}
	
	public void editBookRelease(Book tempBook,int newYear) {
		int oldYear = tempBook.getReleaseDate();
		Session session = factory.getCurrentSession();
		tempBook.setReleaseDate(newYear);;
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldYear + " to " + tempBook.getReleaseDate());
	}
	
	public void editBoookPages(Book tempBook, int newPagesNumber) {
		int oldPagesNumber = tempBook.getReleaseDate();
		Session session = factory.getCurrentSession();
		tempBook.setReleaseDate(newPagesNumber);;
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldPagesNumber + " to " + tempBook.getPages());
	}
	
	public void editBookPublisher(Book tempBook, String newPublisher) {
		String oldPublisher = tempBook.getPublisher();
		Session session = factory.getCurrentSession();
		tempBook.setPublisher(newPublisher);;
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldPublisher + " to " + tempBook.getPublisher());
	}
	
	public void editBookISBN(Book tempBook, String newISBN) {
		String oldISBN = tempBook.getIsbn();
		Session session = factory.getCurrentSession();
		tempBook.setIsbn(newISBN);;
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldISBN + " to " + tempBook.getIsbn());
	}
	
	public Book selectBookById(int tempId) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, tempId);
		//System.out.println("Curent field value: " + tempBook.getTitle());
		return tempBook;
	}
	
	private void printBookList(List<Book> booksList) {
		Book.printFirstTableRow();
		for(Book book : booksList) {
			//System.out.println(book);
			book.PrintTableRow();
		}
		Book.printLastTableRow();
	}
	
}
