package com.nttdata.spring.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.spring.repository.Customer;

/**
 * Interfaz del servicio
 * 
 * @author Jose
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Devuelve todos los clientes
	 * 
	 * @return list
	 */
	public List<Customer> getAllCustomers();

	/**
	 * Busca un cliente por nombre y apellidos
	 * 
	 * @param name     (nombre)
	 * @param surnames (apellidos)
	 * @return list
	 */
	public Customer getCustomerByNameAndSurnames(final String name, final String surnames);

	/**
	 * Inserta o actualiza un cliente
	 * 
	 * @param c (customer)
	 */
	public void insertOrUpdateCustomer(Customer c);

	/**
	 * Borra un cliente
	 * 
	 * @param id (id)
	 */
	public void deleteCustomer(Long id);

	/**
	 * Busca un cliente por id
	 * 
	 * @param id id
	 * @return optional
	 */
	public Optional<Customer> getCustomerById(Long id);

	/**
	 * Busca un cliente por nombre
	 * @param name (nombre)
	 * @return list
	 */
	public List<Customer> getCustomerByName(String name);
}
