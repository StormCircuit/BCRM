package hibernate.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import hibernate.entity.Activity;
import hibernate.entity.Customer;
import hibernate.entity.Order;
import hibernate.entity.Professor;
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
	
	public boolean CreateOrder(Date date,String status, int bronco_id,
			List<Activity> items) {
		
		Session session = DatabaseSession.getInstance().getSession();
		
		try {
			
			List<Activity> tempItems = items;
			double totalCost = 0;
			for(int i = 0; i < tempItems.size(); i++) {
				double cost = tempItems.get(0).getPrice();
				totalCost += cost; 
			}
			System.out.println("Creating Order");
			//Order newOrder = new Order(bronco_id, date, , totalCost, bronco_id, tempItems);
			session.beginTransaction();
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public boolean verifyLogIn(int bronco_id) {
		
		Session session = DatabaseSession.getInstance().getSession();
		
		session.beginTransaction();
		List<Customer> customer = session.createQuery("FROM Customer C WHERE C.bronco_id = :bronco_id", Customer.class).setParameter("bronco_id", bronco_id).getResultList();
		if(customer.isEmpty()) {
			return false;
		}else {
			return true;
			
		}
		
	}
		



}

