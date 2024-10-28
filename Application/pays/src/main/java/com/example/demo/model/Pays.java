package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author mickael mohammed
 *
 */

@Entity
@Table(name="Pays")
public class Pays {
	
	// attributs de la classe
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom ")
	private String nom;
	
	@Column(name="capitale")
	private String capitale;
	
	@Column(name="demographie")
	private String demographie;
	
	@Column(name="superficie")
	private String superficie;
	
	@Column(name="categorie")
	private String categorie;
	
	@Column(name="continent")
	private String continent;
	
	public Pays() {
		
	}
	
	//constructeur pour créer un objet Pays à partir de son nom
	
	public Pays(String nom) {
		this.nom=nom;
	}
	
	// Constructeur pour créer un pays à partir de son nom et son continent
	
	public Pays(String nom, String continent) {
		super();
		this.nom=nom;
		this.continent=continent;
	}
	
	// Constructeur pour créer un pays à partir de son nom, sa catégorie et son continent
	
	public Pays(String nom,String categorie,String Continent) {
		this.nom=nom;
		this.categorie=categorie;
		this.continent=Continent;
	}
	
	// Constructeur pour créer un pays à partir de tous ses attributs
	
	public Pays(String nom, String capitale, String demographie, String superficie, String categorie,
			String continent) {
		super();
		this.nom = nom;
		this.capitale = capitale;
		this.demographie = demographie;
		this.superficie = superficie;
		this.categorie = categorie;
		this.continent = continent;
	}
	
	
	// getters et setters
	
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

	public String getCapitale() {
		return capitale;
	}
	
	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	
	public String getDemographie() {
		return demographie;
	}
	
	public void setDemographie(String demographie) {
		this.demographie = demographie;
	}
	public String getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	// rédéfinition de la méthode toString()
	@Override
	public String toString() {
		return "Pays [nom=" + nom + ", capitale=" + capitale + ", demographie=" + demographie + ", superficie="
				+ superficie + ", categorie=" + categorie + ", continent=" + continent + "]";
	}
	
	
	
	
}
