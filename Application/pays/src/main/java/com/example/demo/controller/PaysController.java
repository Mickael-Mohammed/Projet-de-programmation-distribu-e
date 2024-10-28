package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.repository.*;

/**
 * 
 * @author mickael mohammed 
 *
 *La classe Pays Application recoit les requetes clientes de type GET, POST, PUT et DELETE
 *et traite ces requetes pour afficher les résultats sur un navigateur web
 */
@Service
@RestController
@RequestMapping("pays/")
public class PaysController {

	@Autowired
	PaysRepository repository;
	
	/**
	 * @return la liste de tous les pays
	 */
	
	@GetMapping("")
	public List<Pays> getAll(){
		return this.repository.findAll();
	}
	

	/**
	 * Méthode qui retourne les informations d'un seul pays spécifié dans l'URL de la requete
	 * @param nom du pays
	 * @return pays
	 */
	
	@GetMapping("nom/{nom}")
	public Pays getPays(@PathVariable(value="nom") String nom) {
		
        Pays pays1=new Pays();
		List<Pays> pays= this.repository.findAll();
		for(int i=0;i<pays.size();i++) {
			if(pays.get(i).getNom().equals(nom))
				pays1=pays.get(i);
				
		}
		return pays1;
		
	}
	
	
	/**
	 * Méthode qui retourne tous les objets pays d'un continent spécifié dans l'URL de la requete 
	 * @param nom du continent
	 * @return une liste de pays
	 */
	@GetMapping("continent/{continent}")
	public List<Pays> getPaysDuContinent(@PathVariable(value="continent") String continent) {
		
		List<Pays> result=new ArrayList<Pays>();
		List<Pays> repository=this.repository.findAll();
		
		for(int i=0;i<repository.size();i++) {
			if(repository.get(i).getContinent().equals(continent))
				result.add(repository.get(i));
		}
		
		return result;
	
	}

	
	/**
	 * Méthode qui retourne tous les objets pays d'une catégorie spécifié dans l'URL de la requete
	 * @param categorie
	 * @return une liste de pays
	 */
	
	@GetMapping("categorie/{categorie}")
	public List<Pays> getPaysDeCategorie(@PathVariable(value="categorie") String categorie){
		
		List<Pays> repository=this.repository.findAll();
		List<Pays> result=new ArrayList<Pays>();
		for(int i=0;i<repository.size();i++) {
			if(repository.get(i).getCategorie().equals(categorie))
				result.add(repository.get(i));
		}
		
		return result;
	
		
	}
	
	
	/**
	 * Méthode qui permet d'ajouter un pays à la base de données à partir de son nom
	 * @param nom du pays
	 * @return l'objet Pays créé
	 */
	
	@PostMapping("ajouter/nom/")
	public Pays ajouterPays(@RequestBody String nom) {
		
	    Pays pays=new Pays(nom);
		Pays p=this.repository.save(pays);
		System.out.println("Pays ajouté !");
		System.out.println(pays);
		return p;
	}
	
	/**
	 * Méthode qui permet de créer un objet Pays  à partir de tous ses attributs
	 * et d'ajouter cet objet Pays à la base de données
	 * 
	 * @param pays
	 * @return l'objet Pays créé
	 */
	
	@PostMapping("ajouter/")
	public Pays ajouerPays(@RequestBody Pays pays) {
		this.repository.save(pays);
		return pays;
	}
	
	
	/**
	 * Méthode qui permet de supprimer tous les pays de la base de données lié au navigateur web
	 * (résultat d'affichage dans le navigateur)
	 * @return une liste vide
	 */
	
	@DeleteMapping("tout supprimer/")
	public List<Pays> supprimer() {
		
		 this.repository.deleteAll();
		 return this.repository.findAll();
	}
	
	
	/**
	 * Méthode qui permet de supprimer un pays à partir de son nom spécifié dans le corps de la requete
	 * @param nom
	 * @return la liste des pays après avoir supprimé le pays
	 */
	
	@DeleteMapping("supprimer/")
	public List<Pays> supprimerPays(@RequestBody String nom) {
		
		List<Pays> listePays=this.repository.findAll();
		long id=0;
		for(int i=0;i<listePays.size();i++) {
			if(listePays.get(i).getNom().equals(nom))
				id=listePays.get(i).getId();
				
		}
		this.repository.deleteById(id);
		return this.repository.findAll();
		
	}
	
	
	/**
	 * Méthode qui permet de supprimer tous les pays d'un continent spécifié dans le corps de la requete
	 * @param continent
	 * @return la liste des pays après avoir supprimé tous les pays du continent
	 */
	
	@DeleteMapping("supprimer/continent/")
	public List<Pays> supprimerContinent(@RequestBody String continent){
		
		long id=0;
		List<Pays> listePays=this.repository.findAll();
		
		for(int i=0;i<listePays.size();i++) {
			if(listePays.get(i).getContinent().equals(continent)) {
				id = listePays.get(i).getId();
				this.repository.deleteById(id);
			}
		}
		return this.repository.findAll();
	}
	

	/**
	 * Méthode qui permet de supprimer tous les pays d'une catégorie spécifié dans le corps de la requete
	 * @param categorie
	 * @return la liste des pays après avoir supprimé tous les pays d'une catégorie
	 */
	
	@DeleteMapping("supprimer/categorie/")
	public List<Pays> supprimerPaysDeCategorie(@RequestBody String categorie){
		
		long id=0;
		List<Pays> listePays=this.repository.findAll();
		
		for(int i=0;i<listePays.size();i++) {
			if(listePays.get(i).getCategorie().equals(categorie)) {
				id = listePays.get(i).getId();
				this.repository.deleteById(id);
			}
		}
		return this.repository.findAll();
	}
	
	
	/**
	 * Méthode qui permet de changer la démographie d'un pays à partir du nom de ce pays spécifié dans le corps de la requete
	 * @param nom
	 * @return l'objet Pays modifié
	 */
	
	@PutMapping("/modifier demographie/{nom}")
    public Pays modifierNomPays(@PathVariable String nom,@RequestBody String demographie){
		
		List<Pays> listePays=this.repository.findAll();
		long id=0;
		for(int i=0;i<listePays.size();i++) {
			if(listePays.get(i).getNom().equals(nom))
				id=listePays.get(i).getId();
		}
         this.repository.getById(id).setDemographie(demographie);
         return this.repository.getById(id);
    }
	
	
	/**
	 * Méthode qui permet de changer la catégorie d'un pays à partir du nom de ce pays spécifié dans le corps de la requete
	 * @param nom
	 * @param categorie
	 * @return l'objet Pays modifié
	 */
	
	@PutMapping("/modifier categorie/{nom}")
    public Pays modifierCategoriePays(@PathVariable String nom,@RequestBody String categorie){
		
		List<Pays> listePays=this.repository.findAll();
		long id=0;
		for(int i=0;i<listePays.size();i++) {
			if(listePays.get(i).getNom().equals(nom))
				id=listePays.get(i).getId();
		}
         this.repository.getById(id).setCategorie(categorie);
         return this.repository.getById(id);
    }
	
	
}
