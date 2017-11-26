package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name = "customers", catalog = "businessin")
public class Customers implements java.io.Serializable {

	private Integer id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private Integer postalCode;
	private Integer phone;
	private Date lastActive;
	private Date registerDate;
	private Integer creditCard;
	private Set<Cart> carts = new HashSet<Cart>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Customers() {
	}

	public Customers(String address1, String address2, String city, String state, String country, Integer postalCode,
			Integer phone, Date lastActive, Date registerDate, Integer creditCard, Set<Cart> carts,
			Set<Orders> orderses) {
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.lastActive = lastActive;
		this.registerDate = registerDate;
		this.creditCard = creditCard;
		this.carts = carts;
		this.orderses = orderses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "postalCode")
	public Integer getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "phone")
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lastActive", length = 0)
	public Date getLastActive() {
		return this.lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "registerDate", length = 0)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "creditCard")
	public Integer getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(Integer creditCard) {
		this.creditCard = creditCard;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}
