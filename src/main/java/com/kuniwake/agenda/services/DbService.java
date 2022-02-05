package com.kuniwake.agenda.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuniwake.agenda.domains.Address;
import com.kuniwake.agenda.domains.Contact;
import com.kuniwake.agenda.repositories.AddressRepository;
import com.kuniwake.agenda.repositories.ContactRepository;

@Service
public class DbService {
	
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public void instanceDb() { 
		
		Contact contact = new Contact(null, "julio", "38815302233", "julio@email");
		Contact contact1 = new Contact(null, "Carol", "4545453333", "Carol@email");
		Contact contact2 = new Contact(null, "Ana", "0909090909", "Ana@email");

		Address ad = new Address(null, "22122212", "Teste rua", 89, "Patrocinio", "MG", contact);
		Address ad1 = new Address(null, "878455454", "Avnida ta", 88, "Uberlandia", "MG", contact);
		Address ad2 = new Address(null, "65555555", "rua da pedra", 99, "Paraieee", "AC", contact1);
		Address ad3 = new Address(null, "888778787", "avenida tres", 8955, "goiania", "GO", contact1);
		Address ad4 = new Address(null, "387740006", "praça 78", 63, "patos de minas", "MG", contact1);
		
		contact.getAddress().addAll(Arrays.asList(ad, ad1));
		contact1.getAddress().addAll(Arrays.asList(ad2, ad3, ad4));

		contactRepository.saveAll(Arrays.asList(contact, contact1, contact2));
		addressRepository.saveAll(Arrays.asList(ad, ad1, ad2, ad3, ad4));
		
	}

}
