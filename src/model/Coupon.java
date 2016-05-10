package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the coupon database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Coupon.findAll", query="SELECT c FROM Coupon c"),
@NamedQuery(name="Coupon.findLocale", query="SELECT c FROM Coupon c WHERE c.location = :city")})
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int customerid;

	private String description;

	private String location;

	private String name;
	
	private String description_long;

	public String getDescription_long() {
		return description_long;
	}

	public void setDescription_long(String description_long) {
		this.description_long = description_long;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date validity;

	//bi-directional many-to-one association to Couponbook
	@ManyToOne
	@JoinColumn(name="bookid")
	private Couponbook couponbook;

	public Coupon() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getValidity() {
		return this.validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public Couponbook getCouponbook() {
		return this.couponbook;
	}

	public void setCouponbook(Couponbook couponbook) {
		this.couponbook = couponbook;
	}

}