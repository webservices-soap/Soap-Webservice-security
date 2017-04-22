package com.dugu.dev.ws.security.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ORDER_TB4")
public class OrderModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2478300800972171495L;
	@Id
	@GenericGenerator(name = "IDGEN2", strategy = "increment")
	@GeneratedValue(generator = "IDGEN2")
	@Column(name = "ORDER_ID")
	private int orderId;
	@Column(name = "PRODUCT_NAME")
	private String name;
	@Column(name = "EMAIL")
	private String emailId;
	@Column(name = "MOB")
	private String mobile;
	@Column(name = "GENDER")
	private String gender;
	@OneToMany(targetEntity = ProductModel.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_PRODUCT_FK", referencedColumnName = "ORDER_ID")
	private List<ProductModel> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
