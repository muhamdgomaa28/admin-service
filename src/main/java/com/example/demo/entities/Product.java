package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Product generated by hbm2java
 */
@Where(clause = "product_available =1")
@Entity
@Table(name = "product")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate

public class Product implements java.io.Serializable {

    private Integer id;
    private Brands brands;
    private Business business;
    private Category category;
    private Double price;
    private String pic;
    private Double discount;
    private Double quantity;
    private String productName;
    private String productDescription;
    private Double unitWeight;
    private Double unitStock;
    @Column(name = "productAvailable", columnDefinition = "boolean default true")
    private boolean productAvailable;
    private Integer discountAvailable;
    private String note;
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
    private Set<ProductTrans> productTranses = new HashSet<ProductTrans>(0);
    private Set<Cart> carts = new HashSet<Cart>(0);

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Brands brands, Business business, Category category) {
        this.brands = brands;
        this.business = business;
        this.category = category;
    }

    public Product(Brands brands, Business business, Category category, Double price, String pic, Double discount,
                   Double quantity, String productName, String productDescription, Double unitWeight, Double unitStock,
                   boolean productAvailable, Integer discountAvailable, String note, Set<OrderDetail> orderDetails,
                   Set<ProductTrans> productTranses, Set<Cart> carts) {
        this.brands = brands;
        this.business = business;
        this.category = category;
        this.price = price;
        this.pic = pic;
        this.discount = discount;
        this.quantity = quantity;
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitWeight = unitWeight;
        this.unitStock = unitStock;
        this.productAvailable = productAvailable;
        this.discountAvailable = discountAvailable;
        this.note = note;
        this.orderDetails = orderDetails;
        this.productTranses = productTranses;
        this.carts = carts;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandsid", nullable = false, updatable = false)
    @JsonIgnore
    public Brands getBrands() {
        return this.brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessid", nullable = false, updatable = false)
    @JsonIgnore
    public Business getBusiness() {
        return this.business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid", nullable = false, updatable = false)
    @JsonIgnore
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "price", precision = 22, scale = 0)
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "pic")
    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Column(name = "discount", precision = 22, scale = 0)
    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Column(name = "quantity", precision = 22, scale = 0)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name = "productName")
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "productDescription")
    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Column(name = "unitWeight", precision = 22, scale = 0)
    public Double getUnitWeight() {
        return this.unitWeight;
    }

    public void setUnitWeight(Double unitWeight) {
        this.unitWeight = unitWeight;
    }

    @Column(name = "unitStock", precision = 22, scale = 0)
    public Double getUnitStock() {
        return this.unitStock;
    }

    public void setUnitStock(Double unitStock) {
        this.unitStock = unitStock;
    }

    @Column(name = "productAvailable")
    public boolean isProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }


    @Column(name = "discountAvailable")
    public Integer getDiscountAvailable() {
        return this.discountAvailable;
    }

    public void setDiscountAvailable(Integer discountAvailable) {
        this.discountAvailable = discountAvailable;
    }

    @Column(name = "Note")
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<ProductTrans> getProductTranses() {
        return this.productTranses;
    }

    public void setProductTranses(Set<ProductTrans> productTranses) {
        this.productTranses = productTranses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Cart> getCarts() {
        return this.carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

}
