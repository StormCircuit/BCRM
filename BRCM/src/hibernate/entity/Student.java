package hibernate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="student_id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bronco_id")
	private Customer customer;

	@Column(name="enter_date")
	private Date enterDate;
	
	@Column(name="grad_date")
	private Date gradDate;
	
	@Column(name="major")
	private String major;
	
	@Column(name="minor")
	private String minor;
	
	public Student(Customer customer, Date enterDate, Date gradDate, String major, String minor) {
		super();
		this.customer = customer;
		this.enterDate = enterDate;
		this.gradDate = gradDate;
		this.major = major;
		this.minor = minor;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getGradDate() {
		return gradDate;
	}

	public void setGradDate(Date gradDate) {
		this.gradDate = gradDate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	@Override
	public String toString() {
		return "Student [customer=" + customer + ", enterDate=" + enterDate + ", gradDate=" + gradDate + ", major="
				+ major + ", minor=" + minor + "]";
	}
	
	
}
