package com.example.services;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
	@Test
	void addAppointment_uniqueId_addsAppointment() {
		AppointmentService service = new AppointmentService();
		Date future = new Date(System.currentTimeMillis() + 1000);
		service.addAppointment("1", future, "Dentist");
		assertEquals("Dentist", service.getAppointment("1").getDescription());
	}

	@Test
	void addAppointment_duplicateId_throws() {
		AppointmentService service = new AppointmentService();
		Date future = new Date(System.currentTimeMillis() + 1000);
		service.addAppointment("1", future, "Dentist");
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment("1", future, "Other"));
	}

	@Test
	void deleteAppointment_byId_removesAppointment() {
		AppointmentService service = new AppointmentService();
		Date future = new Date(System.currentTimeMillis() + 1000);
		service.addAppointment("1", future, "Dentist");
		service.deleteAppointment("1");
		assertThrows(IllegalArgumentException.class, () -> service.getAppointment("1"));
	}

	@Test
	void addAppointment_nullAppointment_throws() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment((Appointment) null));
	}

	@Test
	void getAppointment_nullId_throws() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.getAppointment(null));
	}

	@Test
	void getAppointment_missingId_throws() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.getAppointment("missing"));
	}

	@Test
	void deleteAppointment_nullId_throws() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
	}

	@Test
	void deleteAppointment_missingId_throws() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("missing"));
	}
}
