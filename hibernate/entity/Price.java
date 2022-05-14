package hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="historical_price")
public class Price {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="price_id")
	private int id;
	
	@Column(name="price")
	private double price;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;

	public Price(double price, Date date, Activity activity) {
		super();
		this.price = price;
		this.date = date;
		this.activity = activity;
	}

	
	
	
	public Price() {
		super();
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
