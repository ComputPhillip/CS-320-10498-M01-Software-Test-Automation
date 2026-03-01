package com.example.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
	@Test
	void addContact_uniqueId_addsContact() {
		ContactService service = new ContactService();

		service.addContact("1", "John", "Doe", "1234567890", "123 Main St");
		Contact contact = service.getContact("1");

		assertEquals("1", contact.getContactId());
		assertEquals("John", contact.getFirstName());
	}

	@Test
	void addContact_duplicateId_throws() {
		ContactService service = new ContactService();

		service.addContact("1", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class,
				() -> service.addContact("1", "Jane", "Roe", "0987654321", "456 Oak Ave"));
	}

	@Test
	void deleteContact_byId_removesContact() {
		ContactService service = new ContactService();

		service.addContact("1", "John", "Doe", "1234567890", "123 Main St");
		service.deleteContact("1");

		assertThrows(IllegalArgumentException.class, () -> service.getContact("1"));
	}

	@Test
	void updateContactFields_byId_updatesOnlyUpdatableFields() {
		ContactService service = new ContactService();

		service.addContact("1", "John", "Doe", "1234567890", "123 Main St");
		service.updateFirstName("1", "Jane");
		service.updateLastName("1", "Roe");
		service.updatePhone("1", "0987654321");
		service.updateAddress("1", "456 Oak Ave");

		Contact updated = service.getContact("1");
		assertEquals("1", updated.getContactId());
		assertEquals("Jane", updated.getFirstName());
		assertEquals("Roe", updated.getLastName());
		assertEquals("0987654321", updated.getPhone());
		assertEquals("456 Oak Ave", updated.getAddress());
	}

	@Test
	void updateMissingContact_throws() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("missing", "Jane"));
	}
}
