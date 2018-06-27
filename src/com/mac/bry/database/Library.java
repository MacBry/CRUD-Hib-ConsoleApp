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
	
	
	
	private void printBookList(List<Book> booksList) {
		for(Book book : booksList) {
			System.out.println(book);
		}
	}
	
}
