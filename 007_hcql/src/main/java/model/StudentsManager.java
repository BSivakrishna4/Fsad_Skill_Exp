package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class StudentsManager {
	public List<Students> getStudents() throws Exception {
		SessionFactory factory = new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Students> cq = cb.createQuery(Students.class);
	    Root<Students> studentRoot = cq.from(Students.class); //fetch all records from the table
	    
//	    cq.where(cb.lt(studentRoot.get("cgpa"), 9.5)); //Criteria(lt=less than)
//	    cq.where(cb.ge(studentRoot.get("cgpa"), 9.5));
//	    cq.where(cb.le(studentRoot.get("cgpa"), 9.5));
//	    cq.where(cb.gt(studentRoot.get("cgpa"), 9.5));
//	    cq.where(cb.equal(studentRoot.get("cgpa"), 9.5));
//	    cq.where(cb.notEqual(studentRoot.get("cgpa"), 9.5));
//	    cq.where(cb.between(studentRoot.get("cgpa"), 9.2,9.7));
	    cq.where(cb.like(studentRoot.get("name"), "Abdul"));
	    
	    
	    List<Students> slist = session.createQuery(cq).list();
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		return slist;
	}

}
