package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeManger {
	
	public String insertData(Employee E)throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(E); //INSERT OPERATION
		session.getTransaction().commit();
		session.close();
		factory.close();
		return "New employee has been added";
	}
}
