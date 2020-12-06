package org.polytec.vermeg.model;

 
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	
	     
		@Id
		@Column(name="id_user")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_user;
		
	@Column(name="nom")
	private String nom;
		
	@Column(name="prenom")
	private String prenom;
		
	@Column(name="tel")
	private int tel;
		
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy= "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Order> orderList;
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(int id_user, String nom, String prenom, int tel, String email) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
	}
	
	 
	public User() {
		super();
	}
	 
	
}
