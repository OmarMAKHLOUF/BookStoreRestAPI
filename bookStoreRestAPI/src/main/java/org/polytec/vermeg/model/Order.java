package org.polytec.vermeg.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="client_order")
public class Order {
	@Id
	@Column(name="id_cmd")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 	private int id_cmd;
	@Column(name="price_total")
	private double price_total ;
	@Column(name="date_cmd")
	private Date date_cmd;
	@Column(name="quantite")
	private int quantite;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user")
	private User user;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<Commande_ligne> commandeLines;
	
	public int getId_cmd() {
		return id_cmd;
	}
	
	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}
	public double getPrice_total() {
		return price_total;
	}
	public void setPrice_total(double price_total) {
		this.price_total = price_total;
	}
	public Date getDate_cmd() {
		return date_cmd;
	}
	public void setDate_cmd(Date date_cmd) {
		this.date_cmd = date_cmd;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonManagedReference
	public List<Commande_ligne> getCommandeLines() {
		return commandeLines;
	}

	public void setCommandeLines(List<Commande_ligne> commandeLines) {
		this.commandeLines = commandeLines;
	}

	public Order(  int id_cmd, double price_total, Date date_cmd, int quantite) {
		super();
		 
		this.id_cmd = id_cmd;
		this.price_total = price_total;
		this.date_cmd = date_cmd;
		this.quantite = quantite;
	}
	public Order( ) {
		super();
	} 
	
}
