package com.pitu.spring_rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderLineId implements Serializable {
	private static final long serialVersionUID = -8695481425718505230L;

	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="product_id")
	private Long productId;
	
	public OrderLineId() {}
	
	public OrderLineId(Long orderId, Long productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public Long getProductId() {
		return productId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineId other = (OrderLineId) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
}
