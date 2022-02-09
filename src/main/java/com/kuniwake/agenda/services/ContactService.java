package com.kuniwake.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kuniwake.agenda.domains.Contact;
import com.kuniwake.agenda.dtos.ContactDTO;
import com.kuniwake.agenda.exceptions.CustomDataIntegrityViolationExcepition;
import com.kuniwake.agenda.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	public Contact findById(Integer id) {
		Optional<Contact> obj = contactRepository.findById(id);
		return obj.orElse(null);
	}

	public Contact saveContact(Contact c) {
		c.setId(null);// null pois o JPA já cria 1 Id quando for salvar na base
		return contactRepository.save(c);
	}

	public Contact updateContact(Integer id, ContactDTO cDto) {
		Contact c = findById(id);

		c.setName(cDto.getName());
		c.setPhone(cDto.getPhone());
		c.setEmail(cDto.getEmail());

		return contactRepository.save(c);
	}

	public void delContact(Integer id) {
		findById(id);
		try {
			contactRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new CustomDataIntegrityViolationExcepition("Contado de ID: " + id + " não pode ser deletado, possui Endereços associados");
		}
	}

}
