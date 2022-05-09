package hibernate.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hibernate.entity.Activity;

public class demo {

	public static void main(String[] args) {
		DatabaseController db = new DatabaseController();
		
		//db.CreateStudent(13657527, "zrmedina", "123", "Zoe Medina", "04/08/2001", "909-680-2523", "1668 Mill Stream Drive", "09/01/2019", "05/20/2022", "Computer Science", "none");
		//System.out.println(db.verifyLogIn(13657527));
		
		db.CreateActivity("Swimming", 9.99);
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		
		//List<Activity> items = new ArrayList<>();	
		//db.CreateOrder(date, 13657527, items);
	}

}
