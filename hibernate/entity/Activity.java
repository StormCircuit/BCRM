package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {
	public Activity(){
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="activity_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;

	public Activity(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
