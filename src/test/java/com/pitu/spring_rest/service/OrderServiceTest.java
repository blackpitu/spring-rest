package com.pitu.spring_rest.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pitu.spring_rest.domain.Order;
import com.pitu.spring_rest.repository.OrderRepository;

public class OrderServiceTest {
	@InjectMocks 
	private OrderServiceImpl orderService;
	
	@Mock
	private OrderRepository orderRepository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetById() {
		Long id = (long) 3;
		Order order = new Order(id);
		when(orderRepository.findOne(id)).thenReturn(order);
		
		Order result = orderService.getById(id);
		assertEquals(result, order);
	}
	
	@Test
	public void testGetByIdVerify() {
		Long id = (long)3;
		orderService.getById(id);
		
		verify(orderRepository).findOne(id);
		verifyNoMoreInteractions(orderRepository);
	}
}
