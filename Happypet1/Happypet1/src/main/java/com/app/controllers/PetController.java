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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hibernate.BuySell;
import com.hibernate.BuySellPojo;
import com.hibernate.Pet;
import com.hibernate.PetPojo;
import com.hibernate.PetReg;
import com.hibernate.User;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetController {

	
	@GetMapping("/allpets")
	public String getUsers() {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		
		Query query = s.createQuery("from Pet");
		
		List<Pet> list = query.list();

		List<PetPojo> pets = new ArrayList();
		for(Pet p: list)
		{
			pets.add(p.toPOJO());
		}
		String json = new Gson().toJson(pets);
	
		t.commit();
		
		s.close();
		
		return json;

	}
	
	@PostMapping("/viewpets")
	public String viewPet(@RequestBody User user) {
		System.out.println("====================================");
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		
		List<Pet> list = s.createQuery("FROM Pet p WHERE p.user.id =:id ",Pet.class).setParameter("id",user.getId()).getResultList();
//		User u=s.createQuery("from User u where  u.id=:c",User.class).setParameter("c",pet.getUid()).uniqueResult();
//		List<Pet> list = query.list();

		List<PetPojo> pets = new ArrayList();
		for(Pet p: list)
		{
			pets.add(p.toPOJO());
		}
		String json = new Gson().toJson(pets);
	
		t.commit();
		
		s.close();
		
		return json;

	}
	
	@PostMapping("/buyerpetdisp")
	public String BuyerPetDisp(@RequestBody User user) {
		System.out.println("====================================");
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		List<BuySell> p = s.createQuery("FROM BuySell bs WHERE bs.buyer.id =:id ",BuySell.class).setParameter("id",user.getId()).getResultList();
		
		List<Pet> pets_data = new ArrayList();
		for(BuySell p1 : p)
		{
			System.out.println("------------"+p1.getPet());
			pets_data.add(p1.getPet());
		}
//		System.out.println("------------"+p.getPet().getId());
		
//		Pet list = s.createQuery("FROM Pet p WHERE p.user.id =:id ",Pet.class).setParameter("id",p.getPet().getId()).getSingleResult();
//		User u=s.createQuery("from User u where  u.id=:c",User.class).setParameter("c",pet.getUid()).uniqueResult();
//		List<Pet> list = query.list();

//		List<Pet> list = query.list();
//
		List<PetPojo> pets = new ArrayList();
		for(Pet p1: pets_data)
		{
			pets.add(p1.toPOJO());
		}
		String json = new Gson().toJson(pets);
		
		
//		List<Pet> pets = new ArrayList();
//		for(Pet p1 : p.g)
//		{
//			pets.add(p1.g.toPOJO());
//		}
//		String json = new Gson().toJson(pets_data);
//		System.out.println("**************"+json);
		t.commit();
		
		s.close();
		
		return json;
//		return "zz";

	}
	@PostMapping("/getpets")
	public String getPets(@RequestBody Pet pet) {
		System.out.println("====================================");
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		
//		BuySell p = s.createQuery("FROM BuySell p WHERE p.pet.id =:id ",BuySell.class).setParameter("id",pet.getId()).uniqueResult();
		Pet p =s.createQuery("FROM Pet p WHERE p.id =:id ",Pet.class).setParameter("id",pet.getId()).uniqueResult();
//		User u=s.createQuery("from User u where  u.id=:c",User.class).setParameter("c",pet.getUid()).uniqueResult();
//		List<Pet> list = query.list();
//		PetPojo pp = p;
		System.out.println("========="+p);
		int user_id = p.getUser().getId();
		System.out.println("..........,,,,."+user_id);
		User u =s.createQuery("from User u where  u.id=:c",User.class).setParameter("c",user_id).getSingleResult();
		System.out.println("//////////////////"+u);
//		List<PetPojo> pets = new ArrayList();
//		for(Pet p: list)
//		{
//			pets.add(p.toPOJO());
//		}
		String json = new Gson().toJson(u.toPOJO());
		System.out.println("]]]]]]]]]]]"+u);
//		t.commit();
//		
//		s.close();
//		
		return json;
//		return "ok";

	}
	
	
	@PostMapping("/buypets")
	public String BuyPet(@RequestBody PetReg pet) {
		System.out.println("====================================");
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		System.out.println("00000000000=========="+pet.getId());
		BuySell p = s.createQuery("FROM BuySell bs WHERE bs.pet.id =:id ",BuySell.class).setParameter("id",pet.getId()).uniqueResult();

		User u=s.createQuery("from User u where  u.id=:c",User.class).setParameter("c",pet.getUid()).uniqueResult();
		System.out.println("*************"+p);
		System.out.println("*************/"+u);
		p.setBuyer(u);
		s.save(p);
		t.commit();
		
		s.close();
		return "ok";

	}
	
	
	@PostMapping("/addpet")
	public boolean addPet(@RequestBody PetReg pet) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata m=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=m.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		System.out.println(pet+"*********************************");
		Pet p = new Pet();
		BuySell bs = new BuySell();
		p.setAge(pet.getAge());
		p.setBreed(pet.getBreed());
		p.setColor(pet.getColor());
		p.setGender(pet.getGender());
		p.setPetname(pet.getPetname());
		p.setPrice(pet.getPrice());
		p.setStatus(pet.getStatus());
		p.setType(pet.getType());
//		Query q =  s.createNamedQuery("from User where  id=:c");
//		
//		q.setParameter("c", pet.getUid() );
//		
//		User users =(User) q.getSingleResult();
//		User u=s.createQuery("from User rt where rt.username=:username and rt.password=:password",User.class).setParameter("username",user.getUsername()).setParameter("password",user.getPassword()).uniqueResult();
		User u=s.createQuery("from User u where  u.id=:c",User.class).setParameter("c",pet.getUid()).uniqueResult();
		System.out.println("--------------------------------"+u);
		p.setUser(u);
		bs.setPet(p);
		bs.setSeller(u);
		s.save(p);
		s.save(bs);
		
		
		t.commit();
		
		s.close();
		
		return true;
		
	}
}
