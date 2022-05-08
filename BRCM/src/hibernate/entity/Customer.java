package hibernate.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="bronco_id")
	private int bronco_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="DOB")
	private Date DOB;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="customer")
	private List<Order> orders = new ArrayList<>();
	

	public Customer() {
		super();
	}

	public Customer(int bronco_id, String username, String password, String name, Date dOB, String phone,
			String address) {
		super();
		this.bronco_id = bronco_id;
		this.username = username;
		this.password = password;
		this.name = name;
		DOB = dOB;
		this.phone = phone;
		this.address = address;
	}

	public int getBronco_id() {
		return bronco_id;
	}

	public void setBronco_id(int bronco_id) {
		this.bronco_id = bronco_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return "Customer [bronco_id=" + bronco_id + ", name=" + name + ", DOB=" + formatter.format(DOB) + ", phone=" + phone
				+ ", address=" + address + "]";
	}

}
