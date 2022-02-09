package com.kuniwake.agenda.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.kuniwake.agenda.domains.Contact;

public class ContactDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Campo nome é obrigatorio")
	@Length(min = 2, max = 30, message = "Campo nome deve ter de 2 a 30 caracteres ")
	private String name;

	@NotEmpty(message = "Campo Telefone é obrigatorio")
	@Length(min = 8, max = 20, message = "Campo telefone deve ter de 2 a 20 caracteres ")
	private String phone;

	@Column(unique = true)
	private String email;

	public ContactDTO() {
		super();
	}

	// As variaveis de ContactDTO recebe as variaveis de Contact
	public ContactDTO(Contact c) {
		super();
		this.id = c.getId();
		this.name = c.getName();
		this.phone = c.getPhone();
		this.email = c.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
