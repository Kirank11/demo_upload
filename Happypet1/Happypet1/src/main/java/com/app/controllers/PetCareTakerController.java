package com.app.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hibernate.PetCareTaker;

@RestController
@RequestMapping("/api/petcaretaker")
@CrossOrigin

public class PetCareTakerController {
	
	

		@PostMapping("/savepetcaretaker")
		public boolean setPetCaretaker(@RequestBody PetCareTaker petcaretaker) {
			
			
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
			Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=m.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t = s.beginTransaction();
			System.out.println(petcaretaker+"*************************");
			s.save(petcaretaker);
			  
		
			t.commit();
			
			s.close();
			
			return true;

		}
		
		@GetMapping("/allpetcaretaker")
		public String getPetCareTaker() {
			
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
			Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=m.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t = s.beginTransaction();
			
			
			Query query = s.createQuery("from PetCareTaker");
			
			List<PetCareTaker> list = query.list();
			
			System.out.println("fun call");
//			List<PetPojo> pets = new ArrayList();
//			for(Pet p: list)
//			{
//				pets.add(p.toPOJO());
//			}
			String json = new Gson().toJson(list);
		
			t.commit();
			
			s.close();
			
			return json;

		}
	}





