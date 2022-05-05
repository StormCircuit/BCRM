package hibernate.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Activity;
import hibernate.entity.Contains;
import hibernate.entity.Customer;
import hibernate.entity.Order;
import hibernate.entity.Professor;
import hibernate.entity.Staff;
import hibernate.entity.Student;

public class DatabaseController {
	
	private static DatabaseController dbcontroller;
	
	
	public static DatabaseController getInstance() {
		
		if(dbcontroller == null) {
			dbcontroller = new DatabaseController();
		}
		return dbcontroller;
		
	}
	
	public boolean CreateStudent(int b_id, String username, String password, String name, String dob, String phone, String address, String enter_date, String grad_date, String major, String minor ){
		
		
		Session session = DatabaseSession.getInstance().getSession();
		

		try {
		
		System.out.println("Creating Student");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Customer newCustomer = new Customer(b_id, username, password, name, formatter.parse(dob), phone, address);
		Student newStudent = new Student(newCustomer, formatter.parse(enter_date), formatter.parse(grad_date), major, minor);
		
		session.beginTransaction();
		
		session.save(newStudent);
		
		System.out.println("Saving: " + newStudent.toString());
		session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean CreateProfessor(int b_id, String username, String password, String name, String dob, String phone, String address, String department, String office, String research) {
		
		Session session = DatabaseSession.getInstance().getSession();
		
		try {
		
			System.out.println("Creating Professor");
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Customer newCustomer = new Customer(b_id, username, password, name, formatter.parse(dob), phone, address);
			Professor newProfessor = new Professor(newCustomer, department, office, research);
			
			session.beginTransaction();
			
			session.save(newProfessor);
			
			System.out.println("Saving: " + newProfessor.toString());
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
			
	public boolean CreateStaff(String name, String role) {
		
		Session session = DatabaseSession.getInstance().getSession();

		try {
		
			System.out.println("Creating Staff");
			Staff newStaff = new Staff(name, role);
			
			session.beginTransaction();
			session.save(newStaff)
			;
			System.out.println("Saving Staff: " + newStaff.toString());
			session.getTransaction().commit();
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

}

	public boolean CreateActivity(String name, double price) {
		
		Session session = DatabaseSession.getInstance().getSession();
		
		try {
		
			System.out.println("Creating Activity");
			Activity newActivity = new Activity(name, price);
			
			session.beginTransaction();
			session.save(newActivity)
			;
			System.out.println("Saving Activity: " + newActivity.toString());
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean CreateOrder(int order_id, Date date, LocalDateTime time, double total_price, int bronco_id,
			ArrayList<Activity> items) {
		
		Session session = DatabaseSession.getInstance().getSession();
		
		try {
			
			ArrayList<Activity> tempItems = items;
			double totalCost = 0;
			for(int i = 0; i < tempItems.size(); i++) {
				double cost = tempItems.get(0).getPrice();
				totalCost += cost; 
			}
			//get active bronco_id
			System.out.println("Creating Order");
			//Order newOrder = new Order(bronco_id, date, time, totalCost, bronco_id, tempItems);
			session.beginTransaction();
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public boolean verifyLogIn(String user, String pass) {
		
		Session session = DatabaseSession.getInstance().getSession();
		
		session.beginTransaction();
		List<Customer> customer = session.createQuery("FROM Customer C WHERE C.username = :username", Customer.class).setParameter("username", user).getResultList();
		if(customer.isEmpty()) {
			return false;
		}
		Customer currentUser = customer.get(0);
		
		if(currentUser.getPassword().equals(pass)){
			return true;
		}else {
			return false;
		}
		
		
	}
		



}

