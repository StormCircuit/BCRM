package hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Activity;
import hibernate.entity.Customer;
import hibernate.entity.Order;
import hibernate.entity.Professor;
import hibernate.entity.Student;

public class DatabaseSession {
	private static DatabaseSession dbsession;
	private SessionFactory factory;
	private static Session session;
	private static Transaction transaction;
	
	private DatabaseSession() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Activity.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Professor.class)
				.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	public static DatabaseSession getInstance() {
		
		if(dbsession == null) {
			dbsession = new DatabaseSession();
		}
		if(transaction.isActive() == false) {
			transaction = session.beginTransaction();
		}
		return dbsession;
		
	}
	public Session getSession() {
		return session;
	}

	public Transaction getTransaction() {
		return transaction;
	}
		
}
