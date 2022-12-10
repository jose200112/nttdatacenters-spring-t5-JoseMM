package com.nttdata.spring.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerConverter;
import com.nttdata.spring.repository.CustomerDto;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Controlador Rest de cliente
 * 
 * @author Jose
 *
 */
@RestController
public class CustomersRestController {
	
	/** Servicio **/
	@Autowired
	CustomerManagementServiceI customerService;
	
	/** Convertidor **/
	@Autowired
	CustomerConverter converter;

	/**
	 * Busca todos los clientes
	 * @return list
	 */
	@GetMapping(value = "/getCustomers")
	public List<Customer> showCustomers() {
		return customerService.getAllCustomers();
	}
	
	/**
	 * Inserta un nuevo cliente
	 * @param dto (Dto)
	 */
	@PostMapping(value = "/postCustomers")
	public void addCustomer(final @RequestBody CustomerDto dto) {
		Customer customer = converter.dtoToEntity(dto);
		customerService.insertOrUpdateCustomer(customer);
	}

	/**
	 * Borra un cliente
	 * @param id (customerId) 
	 */
	@DeleteMapping(value = "deleteCustomers/{id}")
	public void deleteCustomer(final @PathVariable String id) {
		customerService.deleteCustomer(Long.parseLong(id));
	}
	
	/**
	 * Busca un cliente por nombre y apellidos
	 * @param dto (Dto)
	 * @return Customer
	 */
	@GetMapping(path = "/customer", consumes = "application/json")
	public Customer searchByNameAndSurname(@RequestBody CustomerDto dto) {
		Customer customer = converter.dtoToEntity(dto);
		return customerService.getCustomerByNameAndSurnames(customer.getName(), customer.getSurnames());
	}
	
	/**
	 * Busca un cliente por id
	 * @param dto (Dto)
	 * @return Customer
	 */
	@GetMapping(path = "/customerId", consumes = "application/json")
	public Customer searchById(@RequestBody CustomerDto dto) {
		Customer customer = converter.dtoToEntity(dto);
		Optional<Customer> data = customerService.getCustomerById(customer.getCustomerId());
		if (data.isPresent()) {
			customer = data.get();
		}
		return customer;
	}
	
	/**
	 * Busca los clientes por nombre
	 * @param dto (Dto)
	 * @return list
	 */
	@GetMapping(path = "/customerName", consumes = "application/json")
	public List<Customer> searchByName(@RequestBody CustomerDto dto) {
		Customer customer = converter.dtoToEntity(dto);
		return customerService.getCustomerByName(customer.getName());
	}
	
}
