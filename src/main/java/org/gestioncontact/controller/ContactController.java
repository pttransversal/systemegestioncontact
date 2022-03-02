package org.gestioncontact.controller;

import java.util.List;

import org.gestioncontact.model.Contact;
import org.gestioncontact.repository.ContactRepository;
import org.gestioncontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class ContactController {

	
	@Autowired
	private ContactService contactService;
		
	@Autowired
	private ContactRepository contactRepository;
	
	// display list of contacts
	/*@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listContacts", contactService.getAllEmployees());
		return "index";		
	}*/
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
	   return	findPaginated(1,"nom","asc", model);
	}
	
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		// create model attribute to bind form data
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "new_contact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		// save contact to database
		contactService.saveContact(contact);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get contact from the service
		Contact contact = contactService.getContactById(id);
		
		// set contact as a model attribute to pre-populate the form
		model.addAttribute("contact", contact);
		return "update_contact";
	}
	

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable (value = "id") long id) {
		
		// call delete contact method 
		this.contactService.deleteContactById(id);
		return "redirect:/";
	}
	

	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;
		
		Page<Contact> page = contactService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Contact> listContacts = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listContacts", listContacts);
		return "index";
	}

	
	@GetMapping(value="/cherchercontact")
	public String cherchercontact(Model model,@RequestParam(name="motCle", defaultValue="") String mc) {
		
		List<Contact> contacts =contactRepository.chercherContacts(mc);
		
		model.addAttribute("motCle", mc); 
		model.addAttribute("contacts", contacts);
			return "chercher_contact";
			} 
		
}
