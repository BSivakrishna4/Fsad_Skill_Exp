package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookManager {
	public String insertBook(Book B) throws Exception {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();

		session.persist(B);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return "New book has been added";
	}

	public List<Book> getBooks() throws Exception {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
        List<Book> bookList=session.createQuery("FROM Book",Book.class)
        		                  .getResultList();
        
		session.getTransaction().commit();
		session.close();
		factory.close();
		return bookList;
	}

	public String updateBook(Book B) throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
        Book temp=session.find(Book.class,B.getBookid());
        temp.setTitle(B.getTitle());
        temp.setPrice(B.getPrice());
        session.merge(temp);
        
		session.getTransaction().commit();
		session.close();
		factory.close();	
		return "Data has been updated";
	}
	public String deleteBook(int bookid)throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		Book temp=session.find(Book.class,bookid);
        session.remove(temp);
        
		session.getTransaction().commit();
		session.close();
		factory.close();	
		return "Data has been deleted";
	}
}
