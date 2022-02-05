package com.kuniwake.agenda.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kuniwake.agenda.domains.Contact;
import com.kuniwake.agenda.dtos.ContactDTO;
import com.kuniwake.agenda.services.ContactService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping
	ResponseEntity<List<ContactDTO>> findAll() {
		List<Contact> list = contactService.findAll();

		// Transformando uma Lista de Contact em uma lista de ContactDTO
		List<ContactDTO> listDTO = list.stream().map(obj -> new ContactDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Integer id) {
		Contact contact = contactService.findById(id);
		return ResponseEntity.ok().body(contact);
	}

	@PostMapping
	public ResponseEntity<Contact> saveContact(@Valid @RequestBody Contact c) {
		c = contactService.saveContact(c);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(c);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ContactDTO> updateContact(@Valid @PathVariable Integer id, @RequestBody ContactDTO cDto) {
		Contact c = contactService.updateContact(id, cDto);

		return ResponseEntity.ok().body(new ContactDTO(c));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {
		contactService.delContact(id);
		return ResponseEntity.noContent().build();
		
	}

}
