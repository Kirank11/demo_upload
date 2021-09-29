package com.app.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hibernate.Pet;
import com.hibernate.PetPojo;
import com.hibernate.User;

@RestController
@RequestMapping("/api/registration")
@CrossOrigin
public class UserController {

	@PostMapping("/signup")
	public boolean getUsers(@RequestBody User user) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		
		
		s.save(user);
		
	
		t.commit();
		
		s.close();
		
		return true;

	}
	
	@PostMapping("/login")
	public String loginCheck(@RequestBody User user) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		
		
		
	Query query = s.createQuery("from User where username=: user and password=:pwd");
		
	query.setParameter("user", user.getUsername());
	query.setParameter("pwd", user.getPassword());
	User u = (User) query.getSingleResult();
	System.out.println(u+"*****************************");
	
//		List<Pet> list = query.list();
//
//		List<PetPojo> pets = new ArrayList();
//		for(Pet p: list)
//		{
//			pets.add(p.toPOJO());
//		}
		String json = new Gson().toJson(u.toPOJO());
	
		t.commit();
		
		s.close();
		
		return json;

	}
	
}
