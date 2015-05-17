package com.pitu.spring_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitu.spring_rest.domain.Order;
import com.pitu.spring_rest.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order getById(Long id) {
		return orderRepository.findOne(id);
	}
}
