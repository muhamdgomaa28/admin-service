package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "businessin")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate
public class Category implements java.io.Serializable {

	private Integer id;
	private String name;
	private Integer parentId;
	private Integer active;
	private String pic;
	private Set<Product> products = new HashSet<Product>(0);

	public Category() {
	}

	public Category(String name, Integer parentId, Integer active, String pic, Set<Product> products) {
		this.name = name;
		this.parentId = parentId;
		this.active = active;
		this.pic = pic;
		this.products = products;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parentId")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "active")
	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Column(name = "pic")
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category" ,  cascade = CascadeType.ALL)
//	@JsonIgnore
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
