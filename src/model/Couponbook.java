package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the couponbook database table.
 * 
 */
@Entity
@NamedQuery(name="Couponbook.findAll", query="SELECT c FROM Couponbook c")
public class Couponbook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String additional;

	private String customerid;

	private String description;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date validity;

	//bi-directional many-to-one association to Coupon
	@OneToMany(mappedBy="couponbook")
	private List<Coupon> coupons;

	public Couponbook() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdditional() {
		return this.additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Coupon> getCoupons() {
		return this.coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public Coupon addCoupon(Coupon coupon) {
		getCoupons().add(coupon);
		coupon.setCouponbook(this);

		return coupon;
	}

	public Coupon removeCoupon(Coupon coupon) {
		getCoupons().remove(coupon);
		coupon.setCouponbook(null);

		return coupon;
	}

}