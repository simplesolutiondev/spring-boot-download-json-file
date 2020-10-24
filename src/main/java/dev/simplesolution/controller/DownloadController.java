package dev.simplesolution.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dev.simplesolution.domain.Customer;
import dev.simplesolution.service.JsonExporter;

@Controller
public class DownloadController {
	
	@Autowired
	private JsonExporter jsonExporter;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/downloadJson")
	public ResponseEntity<byte[]> downloadJsonFile() {
		List<Customer> customers = generateCustomerData();
		
		String customerJsonString = jsonExporter.export(customers); 
		
		byte[] customerJsonBytes = customerJsonString.getBytes();
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=customers.json")
				.contentType(MediaType.APPLICATION_JSON)
				.contentLength(customerJsonBytes.length)
				.body(customerJsonBytes);
	}
	
	private List<Customer> generateCustomerData() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer(1, "John", "Doe", "john@simplesolution.dev", "123-456-111");
		customers.add(customer);
		
		customer = new Customer(2, "Stella", "Hudson", "stella@simplesolution.dev", "123-456-222");
		customers.add(customer);
		
		return customers;
	}
 
}
