package com.pitu.spring_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pitu.spring_rest.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
	
	@Query("SELECT COUNT(*) FROM Customer WHERE lastName=:name OR firstName=:name")
	Integer findTotalCustomersWithName(@Param("name") String name);
}
