package dev.simplesolution.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import dev.simplesolution.domain.Customer;
import dev.simplesolution.service.JsonExporter;

@Service
public class JsonExporterImpl implements JsonExporter {

	@Override
	public String export(List<Customer> customers) {
		Gson gson = new Gson();
		String customerInJson = gson.toJson(customers);
		return customerInJson;
	}

}
