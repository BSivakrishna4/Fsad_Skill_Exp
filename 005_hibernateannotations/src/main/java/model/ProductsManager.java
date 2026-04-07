package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductsManager {
	public String insertProduct(Products P)throws Exception
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(P); //INSERT
		session.getTransaction().commit();
		session.close();
		factory.close();
		return "New Product has been added";
	}
}
