package org.gestioncontact.repository;

import java.util.List;

import org.gestioncontact.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("select e from Contact e where e.lien like :x")
	public List<Contact> chercherContacts(@Param("x") String lien);
	
}
