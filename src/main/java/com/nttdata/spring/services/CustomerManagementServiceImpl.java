package com.nttdata.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepository;

/**
 * Servicio Cliente
 * 
 * @author Jose
 *
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	@Autowired
	CustomerRepository customerRepo;


	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerByNameAndSurnames(String name, String surnames) {
		return customerRepo.findByNameAndSurnames(name, surnames);
	}

	@Override
	public void insertOrUpdateCustomer(Customer c) {
		customerRepo.save(c);

	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);

	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepo.findById(id);
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		return customerRepo.findByName(name);
	}
	
	

}
