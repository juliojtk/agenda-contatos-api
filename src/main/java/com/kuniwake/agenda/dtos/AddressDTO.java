package com.kuniwake.agenda.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.kuniwake.agenda.domains.Address;

// Implementação de um DTO como exemplo, foi replicado todos os campos, em vez de apenas alguns.
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = " Campo CEP é Obrigatorio")
	private String CEP;
	
	@NotEmpty(message = "Campo Rua é Obrigatorio")
	private String street;
	
	@NotEmpty(message = "Campo Bairro é Obrigatorio")
	private String district;
	
	private int number;
	private String city;
	private String state;
	private String propertyType;

	public AddressDTO() {
		super();
	}

	public AddressDTO(Address a) {
		super();
		this.id = a.getId();
		this.CEP = a.getCEP();
		this.street = a.getStreet();
		this.district = a.getDistrict();
		this.number = a.getNumber();
		this.city = a.getCity();
		this.state = a.getState();
		this.propertyType = a.getPropertyType();
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

}
