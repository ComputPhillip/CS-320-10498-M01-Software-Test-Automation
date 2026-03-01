package com.example.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
	@Test
	void createContact_validFields_setsAllFields() {
		Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

		assertEquals("123", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}

	@Test
	void createContact_contactIdNull_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
	}

	@Test
	void createContact_contactIdTooLong_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
	}

	@Test
	void createContact_firstNameNull_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", null, "Doe", "1234567890", "123 Main St"));
	}

	@Test
	void createContact_firstNameTooLong_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "12345678901", "Doe", "1234567890", "123 Main St"));
	}

	@Test
	void createContact_lastNameNull_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", null, "1234567890", "123 Main St"));
	}

	@Test
	void createContact_lastNameTooLong_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", "12345678901", "1234567890", "123 Main St"));
	}

	@Test
	void createContact_phoneNull_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", "Doe", null, "123 Main St"));
	}

	@Test
	void createContact_phoneNotTenDigits_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", "Doe", "123", "123 Main St"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", "Doe", "123456789A", "123 Main St"));
	}

	@Test
	void createContact_addressNull_throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", "Doe", "1234567890", null));
	}

	@Test
	void createContact_addressTooLong_throws() {
		String longAddress = "1234567890123456789012345678901"; // 31 chars
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1", "John", "Doe", "1234567890", longAddress));
	}

	@Test
	void contactId_isNotUpdatable() {
		Contact contact = new Contact("abc", "John", "Doe", "1234567890", "123 Main St");
		contact.setFirstName("Jane");
		contact.setLastName("Roe");
		contact.setPhone("0987654321");
		contact.setAddress("456 Oak Ave");
		assertEquals("abc", contact.getContactId());
	}
}
