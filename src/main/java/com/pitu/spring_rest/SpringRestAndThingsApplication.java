package com.pitu.spring_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pitu.spring_rest.domain.Customer;
import com.pitu.spring_rest.repository.CustomerRepository;

@SpringBootApplication
public class SpringRestAndThingsApplication {
	@Autowired
    CustomerRepository customerRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringRestAndThingsApplication.class, args);
    }
    
    public void insertUsers() {
    	customerRepository.save(new Customer("Jack", "Bauer"));
		customerRepository.save(new Customer("Chloe", "O'Brian"));
		customerRepository.save(new Customer("Kim", "Bauer"));
		customerRepository.save(new Customer("David", "Palmer"));
		customerRepository.save(new Customer("Michelle", "Dessler"));
		
		System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
    }
}
