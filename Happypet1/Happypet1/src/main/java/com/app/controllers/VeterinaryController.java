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
import com.hibernate.Veterinary;

@RestController
@RequestMapping("/api/veterinary")
@CrossOrigin
public class VeterinaryController {
	


		@PostMapping("/saveveterinary")
		public boolean setVeterinary(@RequestBody Veterinary veterinary) {
			
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
			Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=m.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t = s.beginTransaction();
			
			s.save(veterinary);
			
		
			t.commit();
			
			s.close();
			
			return true;

		}

        @GetMapping("/allveterinary")
	    public String getVeterinary() {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		
		Query query = s.createQuery("from Veterinary");
		
		List<Veterinary> list = query.list();
//		List<PetPojo> pets = new ArrayList();
//		for(Pet p: list)
//		{
//			pets.add(p.toPOJO());
//		}
		String json = new Gson().toJson(list);
	
		t.commit();
		
		s.close();
		
		return json;

	}
	}




  



   



