package com.contacting.contact.dao;

import java.util.List;

import com.contacting.contact.model.Contact;

public interface ContactDAO {
	public int save(Contact contact);
	
	public int update(Contact contact);
    
    public int delete(int id);
     
    public Contact get(int id);
     
    public List<Contact> list();

}
 