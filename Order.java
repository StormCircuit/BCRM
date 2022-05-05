package hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
	private LocalDateTime time;
	
	@Column(name="total_price")
	private double total_price;
	
	@ManyToOne
	@JoinColumn(name="bronco_id")
	private Customer customer;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
		name = "Contains",
		joinColumns = {@JoinColumn(name="order_id")},
		inverseJoinColumns = {@JoinColumn(name="activity_id")})
	List<Activity> items = new ArrayList<>();


	public Order(int order_id, Date date, LocalDateTime time, double total_price, Customer customer,
			List<Activity> items) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.time = time;
		this.total_price = total_price;
		this.customer = customer;
		this.items = items;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	public double getTotal_price() {
		return total_price;
	}


	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}


	public List<Activity> getItems() {
		return items;
	}


	public void setItems(List<Activity> items) {
		this.items = items;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
