package com.pitu.spring_rest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<OrderLine> lines = new ArrayList<>();
	
	
	
	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public List<OrderLine> getLines() {
		return lines;
	}
}
