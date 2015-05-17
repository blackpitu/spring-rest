package com.pitu.spring_rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_line")
public class OrderLine implements Serializable {
	private static final long serialVersionUID = -5271380844859411525L;

	//	@EmbeddedId
//	private OrderLineId id;
//	
	private int quantity;
	
	private float price;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	@Id
	private Order order;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	@Id
	private Product product;
	
	public OrderLine() {
	}
	
	public OrderLine(Long orderId, Long productId, int quantity, float price) {
		//this.id = new OrderLineId(orderId, productId);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Product getProduct() {
		return product;
	}

//	public Long getOrderId() {
//		return id.getOrderId();
//	}
//
//	public Long getProductId() {
//		return id.getProductId();
//	}

	public int getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}

//	public OrderLineId getId() {
//		return id;
//	}
}
