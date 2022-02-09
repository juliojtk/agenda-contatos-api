package com.kuniwake.agenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kuniwake.agenda.domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("SELECT a FROM Address a WHERE a.contact.id = :id_cont ORDER BY id")
	List<Address> findAllByContact(@Param(value = "id_cont") Integer id_cont);

}
