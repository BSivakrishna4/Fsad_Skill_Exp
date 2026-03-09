package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentManager {
	//FROM clause
	public List<Students> fromClause() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		List<Students> slist = session.createQuery("FROM Students" , Students.class).list();
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		return slist;
	}
	//SELECT Clause
	public List<Students> selectClause() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		List<Students> slist= session.createQuery("SELECT S FROM Students S" , Students.class).list();
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		return slist;
	}
	
	//WHERE Clause
	public List<Students> whereClause() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		List<Students> slist= session.createQuery("FROM Students S WHERE S.sid=30294 " , Students.class).list();
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		return slist;
	}
	
	//Named Parameters
	public List<Students> namedParameters() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		List<Students> slist= session.createQuery("FROM Students S WHERE S.sid=:sid " , Students.class).setParameter("sid", 30294).list();
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		return slist;
	}

	// Aggregate Function: count()
	public String count() throws Exception {
	      SessionFactory factory = new Configuration().configure().buildSessionFactory();
	      Session session = factory.openSession();
	      session.getTransaction().begin();

	      Long count = session
	              .createQuery("SELECT count(S) FROM Students S", Long.class)
	              .getSingleResult();

	      session.getTransaction().commit();
	      session.close();
	      factory.close();

	      return count.toString();
	  }
     // Calculating sum of CGPA
	 public String sumofCGPA() throws Exception {
		  SessionFactory factory = new Configuration().configure().buildSessionFactory();
		  Session session = factory.openSession();
		  session.getTransaction().begin();

		  Double sum = session
		              .createQuery("SELECT sum(S.cgpa) FROM Students S", Double.class)
		              .getSingleResult();
	
		  session.getTransaction().commit();
		  session.close();
		  factory.close();

		return sum.toString();
	 }
     // Calculating average of CGPA
	 public String avgofCGPA() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    session.getTransaction().begin();

		Double average = session
			              .createQuery("SELECT avg(S.cgpa) FROM Students S", Double.class)
			              .getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		factory.close();

		return average.toString();
	 }

	public String minCGPA() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();

		Double min = session.createQuery("SELECT min(S.cgpa) FROM Students S", Double.class).getSingleResult();

		session.getTransaction().commit();
		session.close();
		factory.close();

		return min.toString();
	}	
	public String maxCGPA() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();

		Double max = session.createQuery("SELECT max(S.cgpa) FROM Students S", Double.class).getSingleResult();

		session.getTransaction().commit();
		session.close();
		factory.close();

		return max.toString();
	}	

}
