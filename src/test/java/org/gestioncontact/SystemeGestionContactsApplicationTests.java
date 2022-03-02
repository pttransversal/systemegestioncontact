package org.gestioncontact;

import java.util.List;

import org.gestioncontact.model.Contact;
import org.gestioncontact.repository.ContactRepository;
import org.gestioncontact.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemeGestionContactsApplicationTests {

	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ContactRepository contactRepository;
	/*
	@Test
	void testCreateContact() {
		
		    Contact contact = new Contact("alami"," sara","0987654321","alami.sara@gmail.com","amis");
			contactService.saveContact(contact);
		
		}*/
	/*
	@Test
	void testFindContact() {
		
		    Contact contact = contactRepository.findById(1L).get();
		    System.out.println(contact);
		
		}*/
	
	/*	
	@Test
	void testUpdateContact() {
		
		    Contact contact = contactRepository.findById(1L).get();
		    contact.setPrenom("Siham");
		    contactService.saveContact(contact);
		    System.out.println(contact);
		
		}*/
	
	
	@Test
	void testUpdateContact() {
		
		    Contact contact = contactRepository.findById(2L).get();
		    contact.setPrenom("Siham");
		    contactService.saveContact(contact);
		    System.out.println(contact);
		
		}
	
    /*
	@Test
	void testDeleteContact() {
		
		    contactRepository.deleteById(1L);
		
		}*/
	
	@Test
	void testDeleteContact() {
		
		    contactService.deleteContactById(8L);
		
		}
	
	/*
	@Test
	void testFindAllContact() {
		
		   List<Contact> contact = contactRepository.findAll();
		   
		   for (Contact ct:contact)
			   System.out.println(contact);
		
		}*/
	
	@Test
	void testFindAllContact() {
		
		   List<Contact> contact = contactService.getAllContacts();
		   
		   for (Contact ct:contact)
			   System.out.println(contact);
		
		}
	
	
	
	
	@Test
	void testChercherContact() {
		
		List<Contact> list = contactService.chercherContacts("amis");
		list.forEach(ct -> System.out.println(" ====> " + ct.getNom()));
		
		}
}
