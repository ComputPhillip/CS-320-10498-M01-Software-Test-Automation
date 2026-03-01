package com.example.services;

import java.util.Date;

public final class Appointment {
	private final String appointmentId;
	private final Date appointmentDate;
	private final String description;

	public Appointment(String appointmentId, Date appointmentDate, String description) {
		this.appointmentId = validateId(appointmentId);
		this.appointmentDate = validateDate(appointmentDate);
		this.description = validateDescription(description);
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public Date getAppointmentDate() {
		return new Date(appointmentDate.getTime());
	}

	public String getDescription() {
		return description;
	}

	private static String validateId(String appointmentId) {
		if (appointmentId == null) {
			throw new IllegalArgumentException("appointmentId must not be null");
		}
		if (appointmentId.length() > 10) {
			throw new IllegalArgumentException("appointmentId must be 10 characters or fewer");
		}
		return appointmentId;
	}

	private static Date validateDate(Date appointmentDate) {
		if (appointmentDate == null) {
			throw new IllegalArgumentException("appointmentDate must not be null");
		}
		if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("appointmentDate must not be in the past");
		}
		return new Date(appointmentDate.getTime());
	}

	private static String validateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("description must not be null");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("description must be 50 characters or fewer");
		}
		return description;
	}
}
