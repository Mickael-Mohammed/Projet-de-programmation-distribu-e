package com.example.demo;

/**
 * Mickael MOHAMMED M1 Cybersécurité 51804780
 */

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.model.*;
import com.example.demo.controller.*;
import com.example.demo.repository.*;

/*
 * Classe principale de notre application spring boot web service
 */
@SpringBootApplication
public class PaysApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PaysApplication.class, args);
	}
	
	@Autowired
		private PaysRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//sauvegarde des données dans notre repository
		
		this.repository.save(new Pays("CHINE","Pékin","1.4 milliards d'habitants","9.5 millions km2","pays émergent","asie pacifique"));
		
		this.repository.save(new Pays("AFGHANISTAN","Kaboul","38 millions d'habitants","652860 km2","pays très pauvre","asie centrale"));
		
		this.repository.save(new Pays("NEPAL","Katmandou","29 millions d'habitants","1475016 km2","pays peu développé","asie centrale"));
		
		this.repository.save(new Pays("PAKISTAN","Islamabad","220 millions d'habitants","881913 km2","pays en développement","asie du sud"));
		
		this.repository.save(new Pays("ARABIE-SAOUDITE","Riyad","34 millons d'habitants","2.15 millions km2","pays developpé","asie de l'ouest"));
		
		this.repository.save(new Pays("BANGLADESH","Dacca","164 millions d'habitants","148460 km2","pays très pauvre","asie du sud"));
		
		this.repository.save(new Pays("MALAISIE","Kuala Lumpur","32.3 millions d'habitants","329847 km2","pays développé","asie du sud-est"));
		
	}

}
