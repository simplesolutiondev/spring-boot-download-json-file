package dev.simplesolution.service;

import java.util.List;

import dev.simplesolution.domain.Customer;

public interface JsonExporter {

	String export(List<Customer> customers);
	
}
