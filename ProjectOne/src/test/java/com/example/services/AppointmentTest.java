package com.example.services;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
	@Test
	void createAppointment_validFields_setsAllFields() {
		Date future = new Date(System.currentTimeMillis() + 24L * 60 * 60 * 1000);
		Appointment appointment = new Appointment("a1", future, "Checkup");

		assertEquals("a1", appointment.getAppointmentId());
		assertEquals("Checkup", appointment.getDescription());
		assertEquals(future.getTime(), appointment.getAppointmentDate().getTime());
	}

	@Test
	void createAppointment_appointmentIdNull_throws() {
		Date future = new Date(System.currentTimeMillis() + 1000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment(null, future, "Desc"));
	}

	@Test
	void createAppointment_appointmentIdTooLong_throws() {
		Date future = new Date(System.currentTimeMillis() + 1000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", future, "Desc"));
	}

	@Test
	void createAppointment_dateNull_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", null, "Desc"));
	}

	@Test
	void createAppointment_dateInPast_throws() {
		Date past = new Date(System.currentTimeMillis() - 1000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", past, "Desc"));
	}

	@Test
	void createAppointment_descriptionNull_throws() {
		Date future = new Date(System.currentTimeMillis() + 1000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", future, null));
	}

	@Test
	void createAppointment_descriptionTooLong_throws() {
		Date future = new Date(System.currentTimeMillis() + 1000);
		String longDesc = "123456789012345678901234567890123456789012345678901"; // 51 chars
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", future, longDesc));
	}

	@Test
	void appointmentId_isNotUpdatable() {
		Date future = new Date(System.currentTimeMillis() + 1000);
		Appointment appointment = new Appointment("id", future, "Desc");
		assertEquals("id", appointment.getAppointmentId());
	}
}
