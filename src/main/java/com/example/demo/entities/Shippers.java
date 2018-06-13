package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Shippers generated by hbm2java
 */
@Entity
@Table(name = "shippers", catalog = "businessin")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate
public class Shippers implements java.io.Serializable {

    private Integer id;
    private String companyName;
    private String phone;
    private Set<Orders> orderses = new HashSet<Orders>(0);

    public Shippers() {
    }

    public Shippers(String companyName, String phone, Set<Orders> orderses) {
        this.companyName = companyName;
        this.phone = phone;
        this.orderses = orderses;
    }

    public Shippers(int shipperId) {
        this.id = shipperId;
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

    @Column(name = "companyName")
    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shippers", cascade = CascadeType.ALL)
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
