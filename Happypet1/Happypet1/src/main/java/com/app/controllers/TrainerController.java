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
import com.hibernate.Trainer;

@RestController
@RequestMapping("/api/trainer")
@CrossOrigin
public class TrainerController {
	


		@PostMapping("/savetrainer")
		public boolean setUsers(@RequestBody Trainer trainer) {
			
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
			Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=m.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t = s.beginTransaction();
			
			s.save(trainer);
			
		
			t.commit();
			
			s.close();
			
			return true;

		}
		
		
		
		@GetMapping("/alltrainer")
		public String getTrainer() {
			
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
			Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=m.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t = s.beginTransaction();
			
			Query query = s.createQuery("from Trainer");
			
			List<Trainer> list = query.list();

			String json = new Gson().toJson(list);
		
			t.commit();
			
			s.close();
			
			return json;

		}
	}




  

 


