package org.gestioncontact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "lien")
	private String lien;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String nom, String prenom, String telephone, String email, String lien) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.lien = lien;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email="
				+ email + ", lien=" + lien + "]";
	}
	
	
	
}
