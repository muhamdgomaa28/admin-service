package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cart generated by hbm2java
 */
@Entity
@Table(name = "cart", catalog = "businessin")
public class Cart implements java.io.Serializable {

	private CartId id;
	private Customers customers;
	private Product product;
	private Integer quantity;

	public Cart() {
	}

	public Cart(CartId id, Customers customers, Product product) {
		this.id = id;
		this.customers = customers;
		this.product = product;
	}

	public Cart(CartId id, Customers customers, Product product, Integer quantity) {
		this.id = id;
		this.customers = customers;
		this.product = product;
		this.quantity = quantity;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "customersid", column = @Column(name = "customersid", nullable = false)),
			@AttributeOverride(name = "productid", column = @Column(name = "productid", nullable = false)) })
	public CartId getId() {
		return this.id;
	}

	public void setId(CartId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customersid", nullable = false, insertable = false, updatable = false)
	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
