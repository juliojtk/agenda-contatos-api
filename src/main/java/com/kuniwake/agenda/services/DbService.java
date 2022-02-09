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
		
		Contact contact = new Contact(null, "Julio Kuniwake", "(34) 9-9980-2030", "julio@email.com");
		Contact contact1 = new Contact(null, "Ana Carol", "(31) 9-8850-6096", "Carol@email.com");
		Contact contact2 = new Contact(null, "Paulo ", "(11) 9-8890-8050", "Paulo@email.com");

		Address ad = new Address(null, "38740-006", "Rua Teste", "Morada Nova", 12, "Patrocinio", "Minas Gerais - MG", "Apartamento", contact);
		Address ad1 = new Address(null, "27400-600", "Avenida testando", "Centro", 80, "Uberlandia", "Minas Gerais - MG", "Casa", contact);
		Address ad2 = new Address(null, "65020-000", "Rua Sebastiao dos Fundos", "Nações dos Fundos", 99, "Florianopolis", "Rio Grande do Sul - RS", "Comercio", contact1);
		Address ad3 = new Address(null, "78000-300", "Avenida das Dores", "Santa Efigenia",  1130, "Goiania", "Goiania - GO", "Apartamento", contact1);
		Address ad4 = new Address(null, "24200-500", "Praça dos Doidos", "Serra Negra", 77, "Patos de Minas", "Minas Gerais - MG", "Lote",  contact1);
		
		// Adicionando Dados Ficticios Iniciais
		contact.getAddress().addAll(Arrays.asList(ad, ad1));
		contact1.getAddress().addAll(Arrays.asList(ad2, ad3, ad4));

		contactRepository.saveAll(Arrays.asList(contact, contact1, contact2));
		addressRepository.saveAll(Arrays.asList(ad, ad1, ad2, ad3, ad4));	
	}

}
