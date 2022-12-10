package com.nttdata.spring.repository;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase Dto de Cliente
 * (Propuesto por sonarlint)
 * @author Jose
 *
 */
public class CustomerDto implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) **/
	private Long customerId;

	/** Nombre **/
	private String name;

	/** Apellidos **/
	private String surnames;

	/** fecha de nacimiento **/
	private Date birthdate;

	/** Dni **/
	private String dni;
	
	/**
	 * Devuelve el id del cliente
	 * 
	 * @return customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * Coloca el id del cliente
	 * 
	 * @param customerId (clienteId)
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Devuelve el nombre
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Coloca el nombre
	 * 
	 * @param name (nombre)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve los apellidos
	 * 
	 * @return surnames
	 */
	public String getSurnames() {
		return surnames;
	}

	/**
	 * Coloca los apellidos
	 * 
	 * @param surnames (apellidos)
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * Devuelve la fecha de nacimiento
	 * 
	 * @return birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Coloca la fecha de nacimiento
	 * 
	 * @param birthdate (fechaNacimiento)
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Devuelve el dni
	 * 
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Coloca el dni
	 * 
	 * @param dni (dni)
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
