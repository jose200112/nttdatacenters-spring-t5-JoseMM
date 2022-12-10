package com.nttdata.spring;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Clase principal
 * 
 * @author Jose
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {

	@Autowired
	CustomerManagementServiceI customerService;

	/** LOGGER **/
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);

	/**
	 * Metodo principal
	 * 
	 * @param args (main)
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creacion de clientes
		Customer customer1 = new Customer();
		customer1.setName("Raquel");
		customer1.setSurnames("Garcia Lopez");
		customer1.setDni("28453234E");
		customer1.setBirthdate(Date.valueOf("1998-10-11"));

		Customer customer2 = new Customer();
		customer2.setName("Manuel");
		customer2.setSurnames("Rodriguez Martinez");
		customer2.setDni("58434532Y");
		customer2.setBirthdate(Date.valueOf("2000-02-10"));

		Customer customer3 = new Customer();
		customer3.setName("Maria");
		customer3.setSurnames("Morales Gonzalez");
		customer3.setDni("54856732S");
		customer3.setBirthdate(Date.valueOf("1995-02-12"));

		// Inserciones de clientes
		customerService.insertOrUpdateCustomer(customer1);
		customerService.insertOrUpdateCustomer(customer2);
		customerService.insertOrUpdateCustomer(customer3);

		// Actualizacion de cliente
		customer1.setBirthdate(Date.valueOf("2000-02-15"));
		customerService.insertOrUpdateCustomer(customer1);

		// Borrado de cliente
		customerService.deleteCustomer(3L);

		// Busca cliente por id
		Optional<Customer> data = customerService.getCustomerById(2L);
		if (data.isPresent()) {
			log.info("Cliente con id 2: {}", data.get());

		}

		// Busca todos los clientes
		List<Customer> results = customerService.getAllCustomers();
		for (final Customer ee : results) {
			log.info("Cliente con id {} : {}", ee.getCustomerId(), ee);
		}
		
		log.info("Cliente Manuel Rodriguez Martinez: {}",customerService.getCustomerByNameAndSurnames("Manuel","Rodriguez Martinez"));
	}

}
