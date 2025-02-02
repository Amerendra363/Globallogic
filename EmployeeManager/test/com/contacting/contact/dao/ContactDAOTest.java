package com.contacting.contact.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.contacting.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("8331");
		
		dao=new ContactDAOImpl(dataSource);
		
	}

	@Test
	void testSave() {
		Contact contact=new Contact("Bill Gates","steve@apple.com", "Cupertino,CA","1700123456789");
		int result =dao.save(contact);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		Contact contact=new Contact(2, "Bill Gates","bill.gates@apple.com", "Redmon,wA","1900123456789");
		int result =dao.update(contact);
		
		assertTrue(result>0);
	}

	@Test
	void testDelete() {
		int id=2;
		int result =dao.delete(id);
		
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		int id=1;
		Contact contact=dao.get(id);
		
		if(contact!=null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testList() {
		List<Contact> listContacts=dao.list();
		
		for(Contact aContact : listContacts) {
			System.out.println(aContact);
		}
		
		assertTrue(!listContacts.isEmpty());
	}

}
