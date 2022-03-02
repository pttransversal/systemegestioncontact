package org.gestioncontact.service;

import java.util.List;

import org.gestioncontact.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContactService {
	List<Contact> getAllContacts();
	void saveContact(Contact contact);
	Contact getContactById(long id);
	void deleteContactById(long id);
	Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List<Contact> chercherContacts(String lien);

}
