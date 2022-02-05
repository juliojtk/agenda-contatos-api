package com.kuniwake.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuniwake.agenda.domains.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
