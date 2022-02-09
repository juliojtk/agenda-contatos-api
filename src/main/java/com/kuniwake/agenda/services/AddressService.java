package com.kuniwake.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kuniwake.agenda.domains.Address;
import com.kuniwake.agenda.domains.Contact;
import com.kuniwake.agenda.exceptions.CustomDataIntegrityViolationExcepition;
import com.kuniwake.agenda.exceptions.CustomNotFoundExcepition;
import com.kuniwake.agenda.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactService contactService;

	// Buscar todos os endereços relacionados a um Contato
	public List<Address> getAllAddress(Integer id_cont) {
		contactService.findById(id_cont);
		return addressRepository.findAllByContact(id_cont);
	}

	// Buscar endereço por ID
	public Address findByIdAddress(Integer id) {
		Optional<Address> op = addressRepository.findById(id);
		return op.orElseThrow(() -> new CustomNotFoundExcepition(
				"Endereço de ID " + id + " não encontrado na classe " + Address.class.getName()));
	}

	// Salvar Endereço
	public Address saveAddress(Integer id_contact, Address address) {
		
		address.setId(null);
		Contact contact = contactService.findById(id_contact);
		address.setContacts(contact);
		
		return addressRepository.save(address);
	}

	// Alterando Endereço
	public Address updateAddress(Integer id, Address address) {
		
		Address a = findByIdAddress(id);

		a.setCEP(address.getCEP());
		a.setStreet(address.getStreet());
		a.setDistrict(address.getDistrict());
		a.setNumber(address.getNumber());
		a.setCity(address.getCity());
		a.setState(address.getState());
		a.setPropertyType(address.getPropertyType());

		return addressRepository.save(a);
	}

	// Deletando Endereço
	public void deletAddress(Integer id) {
		findByIdAddress(id);
		try {
			addressRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new CustomDataIntegrityViolationExcepition("Id não foi encontrado" + id + " pode ter alguma relação com tabela Contact");
		}
	}

}
