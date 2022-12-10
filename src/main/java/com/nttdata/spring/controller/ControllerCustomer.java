package com.nttdata.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerConverter;
import com.nttdata.spring.repository.CustomerDto;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Clase controlador
 * @author Jose
 *
 */
@Controller
public class ControllerCustomer {

	private static final String ATTRIBUTE = "customer"; 
	private static final String REDIRECT = "redirect:/customers";

	/** Servicio **/
	@Autowired
	CustomerManagementServiceI customerService;
	
	/** Convertidor **/
	@Autowired
	CustomerConverter converter;
	
	/**
	 * menu principal
	 * @return String
	 */
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	/**
	 * Muestra los clientes
	 * @param modelo (modelo)
	 * @return String
	 */
	@GetMapping({"/customers","/"})
	public String home(Model modelo) {
		List<Customer> data = customerService.getAllCustomers();
		
		modelo.addAttribute("Customers",data);
		return "home";
	}
	
	/**
	 * Crea un cliente con el formulario
	 * @param model (modelo)
	 * @return String
	 */
	@GetMapping("/customers/new")
	public String createCustomerForm(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute(ATTRIBUTE,customer);
		
		return "createCustomer";
	}
	
	/**
	 * Inserta un cliente nuevo
	 * @param dto (dto)
	 * @return String
	 */
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") CustomerDto dto) {
		// Convierte el dto a cliente (Entidad)
		Customer customer = converter.dtoToEntity(dto);
		
		customerService.insertOrUpdateCustomer(customer);
		return REDIRECT;
	}
	
	/**
	 * Consigue el id del cliente a modificar
	 * @param id (id)
	 * @param modelo (modelo)
	 * @return String
	 */
	@GetMapping("/customers/update/{id}")
	public String showEditForm(@PathVariable Long id, Model modelo) {
		Optional<Customer> data = customerService.getCustomerById(id);
		if (data.isPresent()) {
			modelo.addAttribute(ATTRIBUTE, data.get());
		}
		
		return "updateCustomer";
	}
	
	/**
	 * Modifica y Actualiza un cliente
	 * @param id (id)
	 * @param dto (Dto)
	 * @param model (modelo)
	 * @return String
	 */
	@PostMapping("customers/{id}")
	public String modifyCustomer(@PathVariable Long id, @ModelAttribute("customer") CustomerDto dto, Model model) {
		//Convierte el dto a cliente (entidad)
		Customer customerConverted = converter.dtoToEntity(dto);
		
		Optional<Customer> data = customerService.getCustomerById(id);
		if (data.isPresent()) {
			Customer existingCustomer = data.get();

			existingCustomer.setName(customerConverted.getName());
			existingCustomer.setSurnames(customerConverted.getSurnames());
			existingCustomer.setBirthdate(customerConverted.getBirthdate());
			customerService.insertOrUpdateCustomer(existingCustomer);

		}
				
		return REDIRECT;
	}
	
	/**
	 * Borra un cliente por id
	 * @param id (id)
	 * @return String
	 */
	@GetMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return REDIRECT;
	}
	
	/**
	 * Busca a clientes por nombre
	 * @param model modelo
	 * @param nombre nombre
	 * @return String
	 */
	@GetMapping("customers/search")
	public String searchCustomer(Model model, @Param("nombre") String nombre) {
		List<Customer> customers = customerService.getCustomerByName(nombre);
		model.addAttribute(ATTRIBUTE,nombre);
		model.addAttribute("Customers",customers);
		return "searchCustomer";
		
	}
}
