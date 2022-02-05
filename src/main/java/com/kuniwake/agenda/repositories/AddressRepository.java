package com.kuniwake.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuniwake.agenda.domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
