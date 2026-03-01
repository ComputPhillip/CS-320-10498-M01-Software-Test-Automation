package org.snhu.cs320;

public final class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		this.contactId = validateId(contactId);
		this.firstName = validateName(firstName, "firstName");
		this.lastName = validateName(lastName, "lastName");
		this.phone = validatePhone(phone);
		this.address = validateAddress(address);
	}

	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = validateName(firstName, "firstName");
	}

	public void setLastName(String lastName) {
		this.lastName = validateName(lastName, "lastName");
	}

	public void setPhone(String phone) {
		this.phone = validatePhone(phone);
	}

	public void setAddress(String address) {
		this.address = validateAddress(address);
	}

	private static String validateId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("contactId must not be null");
		}
		if (contactId.length() > 10) {
			throw new IllegalArgumentException("contactId must be 10 characters or fewer");
		}
		return contactId;
	}

	private static String validateName(String value, String fieldName) {
		if (value == null) {
			throw new IllegalArgumentException(fieldName + " must not be null");
		}
		if (value.length() > 10) {
			throw new IllegalArgumentException(fieldName + " must be 10 characters or fewer");
		}
		return value;
	}

	private static String validatePhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("phone must not be null");
		}
		if (!phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("phone must be exactly 10 digits");
		}
		return phone;
	}

	private static String validateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("address must not be null");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("address must be 30 characters or fewer");
		}
		return address;
	}
}
