package com.nttdata.spring.repository;

import org.springframework.stereotype.Component;

/**
 * Clase convertidora
 * (Propuesto por sonarlint)
 * @author Jose
 *
 */
@Component
public class CustomerConverter {
	
	/**
	 * Convierte el cliente a Dto
	 * @param customer (cliente)
	 * @return CustomerDto
	 */
	public CustomerDto entityToDto(Customer customer) {
		CustomerDto dto = new CustomerDto();
		dto.setCustomerId(customer.getCustomerId());
		dto.setDni(customer.getDni());
		dto.setName(customer.getName());
		dto.setSurnames(customer.getSurnames());
		dto.setBirthdate(customer.getBirthdate());
		
		return dto;
	}
	
	/**
	 * Convierte el Dto a cliente
	 * @param dto (Dto)
	 * @return Customer
	 */
	public Customer dtoToEntity(CustomerDto dto) {
		Customer customer = new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setDni(dto.getDni());
		customer.setName(dto.getName());
		customer.setSurnames(dto.getSurnames());
		customer.setBirthdate(dto.getBirthdate());
		
		return customer;
	}
}
