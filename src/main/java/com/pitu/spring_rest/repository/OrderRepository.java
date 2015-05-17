package com.pitu.spring_rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.pitu.spring_rest.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
