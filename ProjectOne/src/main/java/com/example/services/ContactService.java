package com.example.services;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();

	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("contact must not be null");
		}
		String contactId = contact.getContactId();
		if (contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID already exists: " + contactId);
		}
		contacts.put(contactId, contact);
	}

	public Contact addContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);
		addContact(contact);
		return contact;
	}

	public void deleteContact(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("contactId must not be null");
		}
		Contact removed = contacts.remove(contactId);
		if (removed == null) {
			throw new IllegalArgumentException("No contact found for ID: " + contactId);
		}
	}

	public void updateFirstName(String contactId, String firstName) {
		getContact(contactId).setFirstName(firstName);
	}

	public void updateLastName(String contactId, String lastName) {
		getContact(contactId).setLastName(lastName);
	}

	public void updatePhone(String contactId, String phone) {
		getContact(contactId).setPhone(phone);
	}

	public void updateAddress(String contactId, String address) {
		getContact(contactId).setAddress(address);
	}

	public Contact getContact(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("contactId must not be null");
		}
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("No contact found for ID: " + contactId);
		}
		return contact;
	}
}
