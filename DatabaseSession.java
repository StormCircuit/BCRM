package hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Activity;
import hibernate.entity.Contains;
import hibernate.entity.Customer;
import hibernate.entity.Order;
import hibernate.entity.Professor;
import hibernate.entity.Student;

public class DatabaseSession {
	private static DatabaseSession dbsession;
	private SessionFactory factory;
	private Session session;
	
	private DatabaseSession() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Activity.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Professor.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	public static DatabaseSession getInstance() {
		
		if(dbsession == null) {
			dbsession = new DatabaseSession();
		}
		return dbsession;
		
	}

	public Session getSession() {
		return session;
	}
		
}
