package com.kuniwake.agenda.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Address {

	private long id;
	private int CEP;
	private String street;
	private int number;
	private String city;
	private String state;

	private List<Contact> contacts = new ArrayList<>();

	public Address() {
		super();
	}

	public Address(long id, int cEP, String street, int number, String city, String state) {
		super();
		this.id = id;
		CEP = cEP;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCEP() {
		return CEP;
	}

	public void setCEP(int cEP) {
		CEP = cEP;
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
