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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kuniwake.agenda.domains.Address;
import com.kuniwake.agenda.dtos.AddressDTO;
import com.kuniwake.agenda.services.AddressService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping
	public ResponseEntity<List<AddressDTO>> getAllAddress() {
		List<Address> list = addressService.getAllAddress();
		
		// Convertendo listAddress em ListAddressDTO
		List<AddressDTO> listDto = list.stream().map(obj -> new AddressDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Integer id) {
		Address a = addressService.findByIdAddress(id);
		return ResponseEntity.ok(a);
	}

	@PostMapping
	public ResponseEntity<Address> saveAddress(@Valid @RequestParam(value = "contact", defaultValue = "0") Integer id_contact, @RequestBody Address address) {
		Address objNew = addressService.saveAddress(id_contact, address);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/address/{id}").buildAndExpand(objNew.getId()).toUri();
		return ResponseEntity.created(uri).body(objNew);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Address> updateAddress(@Valid @PathVariable Integer id, @RequestBody Address address) {
		Address a = addressService.updateAddress(id, address);
		return ResponseEntity.ok().body(a);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
		addressService.deletAddress(id);
		return ResponseEntity.noContent().build();
	}

}
