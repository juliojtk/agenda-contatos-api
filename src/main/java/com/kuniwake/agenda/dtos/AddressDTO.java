package com.kuniwake.agenda.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.kuniwake.agenda.domains.Address;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "CEP Obrigatorio")
	private String CEP;
	private String street;
	private int number;
	private String city;
	private String state;

	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDTO(Address a) {
		super();
		this.id = a.getId();
		this.CEP = a.getCEP();
		this.street = a.getStreet();
		this.number = a.getNumber();
		this.city = a.getCity();
		this.state = a.getState();
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

}
