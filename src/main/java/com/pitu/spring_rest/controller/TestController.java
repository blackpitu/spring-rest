package com.pitu.spring_rest.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pitu.spring_rest.controller.exception.BadNameException;
import com.pitu.spring_rest.controller.exception.CustomerNotFoundException;
import com.pitu.spring_rest.domain.Customer;
import com.pitu.spring_rest.domain.Order;
import com.pitu.spring_rest.domain.Page;
import com.pitu.spring_rest.domain.TestRequest;
import com.pitu.spring_rest.domain.TestResponse;
import com.pitu.spring_rest.repository.CustomerRepository;
import com.pitu.spring_rest.repository.OrderRepository;


@RestController
public class TestController {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@PostConstruct
	public void init() {
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
	
	@RequestMapping("/test")
	public TestResponse test(@RequestParam(value="name", required=false, defaultValue="Jon") String name)
	throws BadNameException{
		if(name.equals("Richard")) {
			throw new BadNameException();
		}
		return new TestResponse(name);
	}
	
	@RequestMapping("/test/{name}/{lastName}")
	public ResponseEntity<TestResponse> testName(@PathVariable String name, @PathVariable String lastName) {
		if(name!="Richard") {
			return new ResponseEntity<TestResponse>( new TestResponse(name +"," + lastName), HttpStatus.OK);
		}
		return new ResponseEntity<TestResponse>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/test-post", method=RequestMethod.POST)
	public TestResponse testPost(@RequestBody TestRequest request) {
		return new TestResponse(request.getName());
	}
	
	@RequestMapping("/test-consume")
	public void testConsume() {
		RestTemplate restTemplate = new RestTemplate();
		Page result = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", Page.class);
		
		System.out.println(result);
	}
	
	@RequestMapping("/test-get-customer/{id}") 
	public Customer getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
		Customer customer =  customerRepository.findOne(id);
		if(customer == null) {
			throw new CustomerNotFoundException();
		}
		
		return customer;
	}
	
	@RequestMapping("/get-count-by-name/{name}")
	public Integer getCountByName(@PathVariable String name) {
		return customerRepository.findTotalCustomersWithName(name);
	}
	
	@RequestMapping("/order/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderRepository.findOne(id);
	}
	
}
