package com.nttdata.spring.repository;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Jose
 *
 *         Clase cliente
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
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
	@Column(name = "NAME")
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
	@Column(name = "SURNAMES")
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
	@Column(name = "BIRTHDATE")
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
	@Column(name = "DNI")
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surnames=" + surnames + ", birthdate="
				+ birthdate + ", dni=" + dni + "]";
	}

}
