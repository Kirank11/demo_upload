package com.app;

import java.util.List;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.Pet;

@SpringBootApplication
public class Happypet1Application {

	public static void main(String[] args) 
	{
		
//		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
//		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
//		SessionFactory sf=m.getSessionFactoryBuilder().build();
//		Session s=sf.openSession();
//		Transaction t = s.beginTransaction();
//		
//		Query q = s.getNamedSQLQuery("from Pet");
//		
//		Pet pet = new Pet();
//		pet.setAge(0);
//		List<Pet> pets = q.list();
//		t.commit();
//		
//		s.close();
		
		SpringApplication.run(Happypet1Application.class, args);
	}

}
