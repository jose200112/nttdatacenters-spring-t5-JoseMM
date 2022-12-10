package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Jose
 * 
 *         Repositorio de clientes
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	/**
	 * Busca un cliente por nombre y apellidos
	 * @param name (nombre)
	 * @param surnames (apellidos)
	 * @return Customer
	 */
	public Customer findByNameAndSurnames(String name, String surnames);
	
	/**
	 * Busca un cliente por nombre
	 * @param name (nombre)
	 * @return list
	 */
	public List<Customer> findByName(String name);

}
