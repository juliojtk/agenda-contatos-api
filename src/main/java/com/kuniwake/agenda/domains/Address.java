package com.kuniwake.agenda.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "CEP Obrigatorio")
	private String CEP;
	
	@NotEmpty(message = "Rua Obrigatorio")
	private String street;
	private int number;
	private String city;
	private String state;


	// @ManyToMany(mappedBy = "address")
	// private Set<Contact> contacts;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;

	public Address() {
		super();
	}

	public Address(Integer id, String CEP, String street, int number, String city, String state, Contact contact) {
		super();
		this.id = id;
		this.CEP = CEP;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Contact getContacts() {
		return contact;
	}

	public void setContacts(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return id == other.id;
	}

}
