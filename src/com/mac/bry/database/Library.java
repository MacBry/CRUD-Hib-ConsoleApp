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
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Book book where book.title='" + tempTitle + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	public void deleteBooksByAuthor(String tempAuthor) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Book book where book.title='" + tempAuthor + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	public void deleteBooksByRelease(int tempYear) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Book book where book.title='" + tempYear + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	public void deleteBooksByNumberOfPages(int tempPageNumb) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Book book where book.title='" + tempPageNumb + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	public void deleteBooksByPublisher(String tempPublisher) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Book book where book.title='" + tempPublisher + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	public void deleteBooksByISBN(String tempISBN) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Book book where book.title='" + tempISBN + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	//EDIT METHODS
	public void editBookTitle(Book tempBook, String newTitle) {
		String oldTitle = tempBook.getTitle();
		Session session = factory.getCurrentSession();
		System.out.println("Curent field value: " + oldTitle);
		tempBook.setTitle(newTitle);
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldTitle + " to " + tempBook.getTitle());
	}
	
	public void editBookAuthor(String tempAuthor, int id) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, id);
		System.out.println("Curent field value: " + tempBook.getAuthor());
		tempBook.setAuthor(tempAuthor);
		session.getTransaction().commit();
	}
	
	public void editBookRelease(int tempYear, int id) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, id);
		System.out.println("Curent field value: " + tempBook.getReleaseDate());
		tempBook.setReleaseDate(tempYear);
		session.getTransaction().commit();
	}
	
	public void editBookNumberOfPage(int tempPageNumb, int id) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, id);
		System.out.println("Curent field value: " + tempBook.getPages());
		tempBook.setPages(tempPageNumb);
		session.getTransaction().commit();
	}
	
	public void editBookPublisher(String tempPublisher, int id) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, id);
		System.out.println("Curent field value: " + tempBook.getPublisher());
		tempBook.setPublisher(tempPublisher);
		session.getTransaction().commit();
	}
	
	public void editBookISBN(String tempISBN, int id) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, id);
		System.out.println("Curent field value: " + tempBook.getIsbn());
		tempBook.setIsbn(tempISBN);
		session.getTransaction().commit();
	}
	
	public Book selectBookById(int tempId) {
		Book tempBook;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempBook = session.get(Book.class, tempId);

		return tempBook;
	}
	
	private void printBookList(List<Book> booksList) {
		for(Book book : booksList) {
			System.out.println(book);
		}
	}
	
}
